package com.test.cm2.Service;

import com.test.cm2.DTO.InstituteDTO;
import com.test.cm2.Mapper.InstituteMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Model.Institute;
import com.test.cm2.Repository.CityRepository;
import com.test.cm2.Repository.InstituteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepository instituteRepository;
    private final InstituteMapper instituteMapper;
    private final CityRepository cityRepository;
    private final CityService cityService;



    public InstituteDTO getInstituteById(Long id) {
        Institute instituteModel = instituteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + id));
        return instituteMapper.toDTO(instituteModel);
    }


    public List<InstituteDTO> getAllInstitutes() {
        List<Institute> instituteModels = instituteRepository.findAll();
        return instituteMapper.toDTOList(instituteModels);
    }


    public void createInstitute(InstituteDTO instituteDTO) {
        Institute institute = instituteMapper.toEntity(instituteDTO);
        institute.setCities(cityService.getAllCities(instituteDTO.getCityIds()));
        instituteRepository.save(institute);
    }



    public void deleteCitiesFromInstitute(Long instituteId, Set<Long> cityIds) {
        Institute institute = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + instituteId));

        Set<City> citiesToDelete = cityRepository.findAllByIds(cityIds);
        institute.getCities().removeAll(citiesToDelete);

        instituteRepository.save(institute);
    }

    public void updateCitiesOfInstitute(Long instituteId, Set<Long> CityIds) {
        Institute institute = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new IllegalArgumentException("Institute not found with ID: " + instituteId));

        Set<City> newCities = cityRepository.findAllByIds(CityIds);
        institute.setCities(newCities);

        instituteRepository.save(institute);
    }




}
