package org.mehmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewUserCreateDto {
    /**
     *
     * */

    Long authid;
    String username;
    String email;
}