package org.mehmet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mehmet.dto.request.YarismaSorulariRequestDto;
import org.mehmet.repository.entity.YarismaSorulari;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IYarismaSorulariMapper {

    IYarismaSorulariMapper INSTANCE = Mappers.getMapper(IYarismaSorulariMapper.class);

    YarismaSorulari toYarismaSorulari (YarismaSorulariRequestDto dto);
}
