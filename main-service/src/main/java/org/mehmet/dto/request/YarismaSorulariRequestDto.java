package org.mehmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class YarismaSorulariRequestDto {

    String token;
    @NotNull
    Long soru_id;
    @NotNull
    Long yarisma_id;
    @NotNull
    Long sure;
    @NotNull
    int sirano;

}
