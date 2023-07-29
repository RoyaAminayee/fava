package com.test.cm2.Mapper;


import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Model.CountryModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy= NullValueMappingStrategy.RETURN_DEFAULT
        ,mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface CountryMapper {
    CountryDTO toDTO(CountryModel countryModel);

//    @Mapping(target = "latinTitle", source = "latinTitle")
    CountryModel toEntity(CountryDTO countryDTO);

//    @Mapping(target = "asdfasdfsa", source = "Cfadfsdf")
    List<CountryDTO> toDTOList(List<CountryModel> countryModels);
}

