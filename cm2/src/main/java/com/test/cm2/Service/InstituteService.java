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

//    public Institute createInstitute(Institute institute) {
//        return instituteRepository.save(institute);
//    }

//
//    public List<InstituteDTO> createInstitute(List<InstituteDTO> instituteDTO, Long City_id) {
//
//        return (List<InstituteDTO>) instituteMapper.toDTO((Institute) savedInstitute);
//    }



    public InstituteDTO getInstituteById(Long id) {
        Institute instituteModel = instituteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + id));
        return instituteMapper.toDTO(instituteModel);
    }


//
//        public Page<InstituteDTO> getAllInstitutes(Pageable pageable) {
//        Page<Institute> institutePage = instituteRepository.findAll(pageable);
//        return institutePage.map(instituteMapper::toDTO);
//    }


    public List<InstituteDTO> getAllInstitutes() {
        List<Institute> instituteModels = instituteRepository.findAll();
        return instituteMapper.toDTOList(instituteModels);
    }


//    public Institute updateInstitute(Long id, Institute institute) {
//        Institute existingInstitute = getInstituteById(id);
//        // Perform the update logic here with institute's fields
//        return instituteRepository.save(existingInstitute);
//    }


//    public InstituteDTO updateInstitute(Long id, InstituteDTO instituteDTO) {
//        Institute instituteModel = instituteRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("institute not found with ID: " + id));
//
//
//        instituteRepository.save(instituteModel);
//        return instituteDTO;
//    }


    public void deleteInstitute(Long id) {
        if (!instituteRepository.existsById(id)) {
            throw new EntityNotFoundException("Country not found with ID: " + id);
        }
        instituteRepository.deleteById(id);
    }
////////////////    havasaet bashe bayad az city ha ham hazf she


//    public InstituteDTO updateInstituteCities(Long id, List<Long> cityIds) {
//        Institute instituteModel = instituteRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + id));
//
//        Set<City> updatedCities = new HashSet<>();
//        for (Long cityId : cityIds) {
//            City city = cityRepository.findById(cityId)
//                    .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + cityId));
//            updatedCities.add(city);
//        }
//
//        instituteModel.setCities(updatedCities);
//        instituteRepository.save(instituteModel);
//
//        return instituteMapper.toDTO(instituteModel);
//    }


//        private final CityRepository cityRepository;


//        public InstituteDTO updateInstituteCities(Long id, List<Long> cityIds) {
//            Institute instituteModel = instituteRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + id));
//
//            Set<City> updatedCities = new HashSet<>();
//            for (Long cityId : cityIds) {
//                City city = cityRepository.findById(cityId)
//                        .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + cityId));
//                updatedCities.add(city);
//            }
//
//            instituteModel.setCities(updatedCities);
//            Institute savedInstitute = instituteRepository.save(instituteModel);
//
//            return instituteMapper.toDTO(savedInstitute);
//        }


    public InstituteDTO addCitiesToInstitute(Long instituteId, List<Long> cityIds) {
        Institute instituteModel = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + instituteId));

        Set<City> cities = new HashSet<>();
        for (Long cityId : cityIds) {
            City city = cityRepository.findById(cityId)
                    .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + cityId));
            cities.add(city);
        }

        instituteModel.setCities(cities);
        Institute updatedInstitute = instituteRepository.save(instituteModel);
        return instituteMapper.toDTO(updatedInstitute);
    }

}