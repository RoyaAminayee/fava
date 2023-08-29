package com.test.cm2.DTO.Service;

import com.test.cm2.DTO.StateDTO;

import com.test.cm2.Mapper.StateMapper;
import com.test.cm2.Model.StateModel;

import com.test.cm2.Mapper.Repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;
    private final StateMapper stateMapper;



    public StateDTO createState(StateDTO stateDTO) {
        StateModel stateModel = stateMapper.toEntity(stateDTO);
        StateModel savedState = stateRepository.save(stateModel);
        return stateMapper.toDTO(savedState);
    }



    public StateDTO getStateById(Long StateId) {
        StateModel stateModel = stateRepository.findById(StateId)
                .orElseThrow(() -> new EntityNotFoundException("State not found with ID: " + StateId));
        return stateMapper.toDTO(stateModel);
    }



    public List<StateDTO> getAllStates() {
        List<StateModel> stateModels = stateRepository.findAll();
        return stateMapper.toDTOList(stateModels);
    }



    public StateDTO updateState(Long StateId, StateDTO stateDTO) {
        StateModel stateModel = stateRepository.findById(StateId)
                .orElseThrow(() -> new EntityNotFoundException("State not found with ID: " + StateId));

        // Update the fields of the countryModel with the fields from countryDTO

        stateRepository.save(stateModel);
        return stateDTO;
    }

//    public void updateCountry(Long id, CountryDTO countryDTO) {
//        CountryModel countryModel = countryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));
//
//        // Update the fields of the countryModel with the fields from countryDTO
//
//        countryRepository.save(countryModel);
//    }

    public void deleteState(Long StateId) {
        if (!stateRepository.existsById(StateId)) {
            throw new EntityNotFoundException("State not found with ID: " + StateId);
        }
        stateRepository.deleteById(StateId);
    }



//    public List<StateDTO> getAllStatesByCountryId(Long countryId) {
//        List<StateModel> stateModels = stateRepository.findById(countryId);
//        return stateMapper.toDTOList(stateModels);
//    }
//




//    public List<StateDTO> getAllStatesByCountryId(Long countryId) {
//        // Fetch the states of the given country from the database using the stateRepository
//        List<StateModel> states = stateRepository.findById(countryId);
//
//        // Convert StateModel list to StateDTO list using the StateMapper
//        return stateMapper.toDTOList(states);
//    }
}


