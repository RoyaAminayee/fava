package com.test.cm2.DTO.Service;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.Mapper.CityMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Mapper.Repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityDTO createCity(CityDTO cityDTO) {
        City cityModel = cityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(cityModel);
        return cityMapper.toDTO(savedCity);
    }

//    public CityDTO getCityById(Long id) {
//        City cityModel = cityRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + id));
//        return cityMapper.toDTO(cityModel);
//    }

        public City getCityById(Long id) {
        City cityModel = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + id));
        return cityModel;
    }

    public Set<City> getAllCities(Set<Long> ids) {
        Set<City> allById = cityRepository.findAllByIds(ids);
        return allById;
    }

    public CityDTO updateCity(Long id, CityDTO cityDTO) {
        City cityModel = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + id));

        // Update the fields of the cityModel with the fields from cityDTO

        cityRepository.save(cityModel);
        return cityDTO;
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new EntityNotFoundException("City not found with ID: " + id);
        }
        cityRepository.deleteById(id);
    }


    public List<City> getCitiesWithCriteria(String keyword) {
        return cityRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + keyword.toLowerCase() + "%")
        );
    }

}




