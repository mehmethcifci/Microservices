package org.mehmet.service;

import org.mehmet.config.security.JwtTokenManager;
import org.mehmet.dto.request.DoLoginRequestDto;
import org.mehmet.dto.request.NewUserCreateDto;
import org.mehmet.dto.request.RegisterRequestDto;
import org.mehmet.manager.IUserManager;
import org.mehmet.rabbitmq.model.CreateUser;
import org.mehmet.rabbitmq.producer.CreateUserProducer;
import org.mehmet.repository.IAuthRepository;
import org.mehmet.repository.entity.Auth;
import org.mehmet.repository.enums.Role;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    private final CreateUserProducer createUserProducer;

    private final JwtTokenManager jwtTokenManager;
    public AuthService(IAuthRepository authRepository, IUserManager userManager,
                       CreateUserProducer createUserProducer, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
        this.createUserProducer = createUserProducer;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Optional<Auth> doLogin(DoLoginRequestDto dto){
        String encodedPassword = jwtTokenManager.encryptPassword(dto.getPassword());
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(),
                encodedPassword);
    }
    public Auth register(RegisterRequestDto dto){
        String encodedPassword = jwtTokenManager.encryptPassword(dto.getPassword());
        Auth auth;
        auth = Auth.builder()
                .password(encodedPassword)
                .username(dto.getUsername())
                .role(Role.USER)
                .build();
        if(dto.getRoleAdminPassword()!=null)
            if(dto.getRoleAdminPassword().equals("123456"))
                auth.setRole(dto.getRole()==null ? Role.ADMIN : dto.getRole());
            else
                auth.setRole(Role.USER);

        save(auth);
        /*
        User Service e kulanıcının profilin oluşması için istek gönderir.
        userManager.NewUserCreate(
                NewUserCreateDto.builder()
                        .authid(auth.getId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build()
        );
         */
        createUserProducer.sendCreateUserMessage(CreateUser.builder()
                .authid(auth.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(encodedPassword)
                .build());
        return auth;
    }


}