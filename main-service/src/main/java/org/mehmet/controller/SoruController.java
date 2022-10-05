package org.mehmet.controller;

import lombok.RequiredArgsConstructor;
import org.mehmet.dto.request.SoruEklemeRequestDto;
import org.mehmet.exception.ErrorType;
import org.mehmet.exception.MainManagerException;
import org.mehmet.service.SorularService;
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
@RequestMapping(BASE_URL + MAIN + SORU)
@RequiredArgsConstructor
public class SoruController {

    private final SorularService sorularService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createSoru(@RequestBody @Valid SoruEklemeRequestDto dto){

        try{
            Optional<Long> userid = jwtTokenManager.getUserId(dto.getToken());
            if (userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            sorularService.soruEkle(dto);


            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }

    }


}
