package org.mehmet.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


import org.mapstruct.factory.Mappers;
import org.mehmet.dto.request.YarismaRequestDto;
import org.mehmet.repository.entity.Yarisma;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IYarismaMapper {

    IYarismaMapper INSTANCE = Mappers.getMapper(IYarismaMapper.class);


    @Mappings({
            @Mapping(source = "userid", target = "yarismasahibiuserid"),
            @Mapping(source = "baslik", target = "yarismabaslik"),
            @Mapping(source = "tanim", target = "yarismatanimi")
    })
    Yarisma toYarisma(YarismaRequestDto dto);
}
