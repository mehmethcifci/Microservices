package org.mehmet.mapper;

import javax.annotation.processing.Generated;
import org.mehmet.dto.request.YarismaSorulariRequestDto;
import org.mehmet.repository.entity.YarismaSorulari;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-10T14:26:53+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class IYarismaSorulariMapperImpl implements IYarismaSorulariMapper {

    @Override
    public YarismaSorulari toYarismaSorulari(YarismaSorulariRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        YarismaSorulari.YarismaSorulariBuilder yarismaSorulari = YarismaSorulari.builder();

        yarismaSorulari.soru_id( dto.getSoru_id() );
        yarismaSorulari.yarisma_id( dto.getYarisma_id() );
        yarismaSorulari.sure( dto.getSure() );
        yarismaSorulari.sirano( dto.getSirano() );

        return yarismaSorulari.build();
    }
}
