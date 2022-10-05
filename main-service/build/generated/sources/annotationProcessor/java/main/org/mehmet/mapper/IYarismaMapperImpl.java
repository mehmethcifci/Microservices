package org.mehmet.mapper;

import javax.annotation.processing.Generated;
import org.mehmet.dto.request.YarismaRequestDto;
import org.mehmet.repository.entity.Yarisma;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T15:47:07+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class IYarismaMapperImpl implements IYarismaMapper {

    @Override
    public Yarisma toYarisma(YarismaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Yarisma.YarismaBuilder yarisma = Yarisma.builder();

        yarisma.yarismasahibiuserid( dto.getUserid() );
        yarisma.yarismabaslik( dto.getBaslik() );
        yarisma.yarismatanimi( dto.getTanim() );
        yarisma.resim( dto.getResim() );
        yarisma.kazanacakkisisayisi( dto.getKazanacakkisisayisi() );

        return yarisma.build();
    }
}
