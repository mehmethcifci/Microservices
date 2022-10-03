package org.mehmet.service;

import org.mehmet.dto.request.DoLoginRequestDto;
import org.mehmet.dto.request.NewUserCreateDto;
import org.mehmet.dto.request.RegisterRequestDto;
import org.mehmet.manager.IUserManager;
import org.mehmet.repository.IAuthRepository;
import org.mehmet.repository.entity.Auth;
import org.mehmet.repository.enums.Role;
import org.mehmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    public AuthService(IAuthRepository authRepository, IUserManager userManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
    }
    public Optional<Auth> doLogin(DoLoginRequestDto dto){
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(), dto.getPassword());

    }

    public Auth register(RegisterRequestDto dto){
            Auth auth;
            auth = Auth.builder()
                    .password(dto.getPassword())
                    .username(dto.getUsername())
                    .email(dto.getEmail())
                    .build();
            if(dto.getRoleAdminPassword()!=null)
                if(dto.getRoleAdminPassword().equals("123456"))
                    auth.setRole(dto.getRole()==null ? Role.ADMIN : dto.getRole());
                else
                    auth.setRole(Role.USER);
        save(auth);
        userManager.NewUserCreate(NewUserCreateDto.builder()
                        .authid(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                        .build());
            return auth;
        }
}
