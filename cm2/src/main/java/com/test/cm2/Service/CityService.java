package com.test.cm2.Service;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.Mapper.CityMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
}


