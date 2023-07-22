package com.test.cm2.Mapper;


import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Model.CountryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CountryMapper {
    @Mapping(target = "latinTitle" , source = "latinTitle")
    CountryDTO toDTO(CountryModel countryModel);

    @Mapping(target = "latinTilte", source = "latinTitle")
    CountryModel toEntity(CountryDTO countryDTO);
}
