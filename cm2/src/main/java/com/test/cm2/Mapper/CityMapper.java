package com.test.cm2.Mapper;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.Model.City;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface CityMapper {
    CityDTO toDTO(City cityModel);

    City toEntity(CityDTO cityDTO);

    List<CityDTO> toDTOList(List<City> cityModels);
}
