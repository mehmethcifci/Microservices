package org.mehmet.utility;

import lombok.RequiredArgsConstructor;
import org.mehmet.dto.request.RegisterRequestDto;
import org.mehmet.repository.enums.Role;
import org.mehmet.service.AuthService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AuthImpl {


    private final AuthService authService;

    //@PostConstruct
    public void init() {
        for (int i = 0; i < 2000; i++) {
            authService.register(RegisterRequestDto.builder()
                    .username("admin")
                    .email("admin@admin.com")
                    .password("123456")
                    .role(Role.ADMIN)
                    .RoleAdminPassword("123456")
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("serpil")
                    .email("serpil@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("deniz")
                    .email("deniz@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("bahar")
                    .email("bahat@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("tekin")
                    .email("tekin@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("berk")
                    .email("berk@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("cansu")
                    .email("cansu@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("zeynep")
                    .email("zeynep@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("akın")
                    .email("akın@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("ahmet")
                    .email("ahmet@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("ceren")
                    .email("ceren@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("ersin")
                    .email("ersin@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("ferhat")
                    .email("ferhat@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("gunes")
                    .email("gunes@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("hakkı")
                    .email("hakki@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
            authService.register(RegisterRequestDto.builder()
                    .username("kerim")
                    .email("kerim@uygulama.com")
                    .password("123456")
                    .role(Role.USER)
                    .build());
        }
    }
}