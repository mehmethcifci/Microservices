package org.mehmet.controller;

import lombok.RequiredArgsConstructor;
import org.mehmet.dto.request.YarismaRequestDto;
import org.mehmet.exception.ErrorType;
import org.mehmet.exception.MainManagerException;
import org.mehmet.repository.entity.Yarisma;
import org.mehmet.service.YarismaService;
import org.mehmet.utility.JwtTokenManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static org.mehmet.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL + MAIN + YARISMA)
@RequiredArgsConstructor
public class YarismaController {

    private final YarismaService yarismaService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Yarisma> createYarisma(@RequestBody @Valid YarismaRequestDto dto){

        try{
            Optional<Long> userid =  jwtTokenManager.getUserId(dto.getToken());
            if (userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);


            return ResponseEntity.ok(yarismaService.save(dto));

        }catch (Exception e){
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }

    }
}
