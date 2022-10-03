package org.mehmet.controller;

import lombok.RequiredArgsConstructor;
import org.mehmet.dto.request.SoruGrupRequestDto;
import org.mehmet.exception.ErrorType;
import org.mehmet.exception.MainManagerException;
import org.mehmet.repository.entity.SoruGrubu;
import org.mehmet.service.SoruGrubuService;
import org.mehmet.utility.JwtTokenManager;
import org.mehmet.constant.ApiUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(ApiUrl.BASE_URL+ ApiUrl.MAIN + ApiUrl.SORU_GRUP)
@RequiredArgsConstructor
public class SoruGrupController {

    private final JwtTokenManager jwtTokenManager;
    private final SoruGrubuService soruGrubuService;

    @PostMapping(ApiUrl.CREATE_SORU_GROUP)
    public ResponseEntity<SoruGrubu> createSoruGrup(SoruGrupRequestDto dto){
        try{
            Optional<Long> userid = jwtTokenManager.getUserId(dto.getToken());
            if(userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            /**
             * Burada gelen userid nin ilgili işlemi yapabilecek yetkisinin
             * olup olmadığı kontrol edilerek işleme izin verilmelidir*/
            return ResponseEntity.ok(soruGrubuService.save(SoruGrubu.builder()
                    .grupadi(dto.getGrupadi())
                    .build()));

        }catch (Exception e){}
        return ResponseEntity.badRequest().build();
    }


}
