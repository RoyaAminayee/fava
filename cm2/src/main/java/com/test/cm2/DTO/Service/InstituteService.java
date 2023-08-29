package com.test.cm2.DTO.Service;

import com.test.cm2.DTO.InstituteDTO;
import com.test.cm2.Mapper.InstituteMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Model.Institute;
import com.test.cm2.Mapper.Repository.CityRepository;
import com.test.cm2.Mapper.Repository.InstituteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


    public void deleteCitiesOfInstitute(Long instituteId, Set<Long> cityIds) {
        Institute institute = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + instituteId));

        Set<City> citiesToDelete = cityRepository.findAllByIds(cityIds);
        institute.getCities().removeAll(citiesToDelete);

        instituteRepository.save(institute);
    }


    public void updateCitiesOfInstitute(Long instituteId, Set<Long> newCityIds) {
        Institute institute = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new EntityNotFoundException("Institute not found with ID: " + instituteId));

        Set<City> existingCities = institute.getCities();

        Set<City> newCities = cityRepository.findAllByIds(newCityIds);

        //new-exist
        Set<City> citiesToAdd = newCities;
        citiesToAdd.removeAll(existingCities);
        //exist-new
        Set<City> citiesToRemove = existingCities;
        citiesToRemove.removeAll(newCities);

        institute.getCities().addAll(citiesToAdd);

        institute.getCities().removeAll(citiesToRemove);

        instituteRepository.save(institute);
    }



    public List<Institute> getInstitutesByCityCriteria(String title, String name) {
        return instituteRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Institute, City> cityJoin = root.join("cities");
            Predicate cityTitlePredicate = criteriaBuilder.equal(criteriaBuilder.lower(cityJoin.get("Title")), title.toLowerCase());
            Predicate instituteNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
            return criteriaBuilder.and(cityTitlePredicate, instituteNamePredicate);
        });
    }


}


