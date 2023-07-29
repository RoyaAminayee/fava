package com.test.cm2.Mapper;

import com.test.cm2.DTO.StateDTO;
import com.test.cm2.Model.StateModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface StateMapper {
    StateDTO toDTO(StateModel stateModel);

    StateModel toEntity(StateDTO stateDTO);
//    StateModel toEntity(StateModel stateModel);
    List<StateDTO> toDTOList(List<StateModel> stateModel);
}

