package com.test.cm2.Mapper;

import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.DTO.InstituteDTO;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.Model.Institute;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring"
        ,mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface InstituteMapper {
    InstituteDTO toDTO(Institute institute);
    Institute toEntity(InstituteDTO instituteDTO);
    List<InstituteDTO> toDTOList(List<Institute> institutes);

}

