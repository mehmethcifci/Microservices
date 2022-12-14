package org.mehmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SoruEklemeRequestDto {
    private String token;
    private SoruRequestDto soru;
    private List<CevaplarRequestDto> cevaplar;
}
