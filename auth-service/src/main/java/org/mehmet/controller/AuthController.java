package org.mehmet.controller;

import org.mehmet.dto.request.DoLoginRequestDto;
import org.mehmet.dto.request.RegisterRequestDto;
import org.mehmet.repository.entity.Auth;
import org.mehmet.service.AuthService;
import org.mehmet.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static org.mehmet.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;

    @GetMapping("/test")
    public String getTestString(){
        return "Auth test";
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto) {
        Optional<Auth> auth = authService.doLogin(dto);
        if(auth.isPresent()){
        String token = jwtTokenManager.createToken(auth.get().getId()).get();
        return ResponseEntity.ok(token);
        }
     return ResponseEntity.badRequest().body("Girişi başarısız");
    }
    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        authService.register(dto);
        return ResponseEntity.ok().build();
    }
}
