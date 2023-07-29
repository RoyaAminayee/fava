package com.test.cm2.Service;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.Mapper.CityMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CityDTO getCityById(Long id) {
        City cityModel = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + id));
        return cityMapper.toDTO(cityModel);
    }

    public List<CityDTO> getAllCities() {
        List<City> cityModels = cityRepository.findAll();
        return cityMapper.toDTOList(cityModels);
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


