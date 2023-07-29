package com.test.cm2.Service;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.DTO.StateDTO;
import com.test.cm2.Mapper.CountryMapper;
import com.test.cm2.Mapper.StateMapper;
import com.test.cm2.Model.City;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.Model.StateModel;
import com.test.cm2.Repository.CityRepository;
import com.test.cm2.Repository.CountryRepository;
import com.test.cm2.Repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryModel> getCountriesByCriteria(String fieldName, String operator, String value) {
        Specification<CountryModel> spec = (root, query, criteriaBuilder) -> {
            if (operator.equals("equal")) {
                return criteriaBuilder.equal(root.get(fieldName), value);
            } else if (operator.equals("contains")) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(fieldName)), "%" + value.toLowerCase() + "%");
            }
            // Add more conditions as needed for other operators
            return null;
        };
        return countryRepository.findAll(spec);
    }


//    Specification<Product> nameLike =
//            (root, query, criteriaBuilder) ->
//                    criteriaBuilder.like(root.get(Product_.NAME), "%"+name+"%");


    public CountryDTO createCountry(CountryDTO countryDTO) {
        CountryModel countryModel = countryMapper.toEntity(countryDTO);
        CountryModel savedCountry = countryRepository.save(countryModel);
        return countryMapper.toDTO(savedCountry);
    }



    public CountryDTO getCountryById(Long id) {
        CountryModel countryModel = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));
        return countryMapper.toDTO(countryModel);
    }

//    public CountryServiceClass() {
//
//    }


    public List<CountryDTO> getAllCountries() {
        List<CountryModel> countryModels = countryRepository.findAll();
//        return countryModels;
        return countryMapper.toDTOList(countryModels);
//        List<CountryDTO> testc = new ArrayList<>();
//        testc.add(new CountryDTO(1,"a","aa","aaa"));
//        testc.add(new CountryDTO(2,"b","bb","bbb"));
//        testc.add(new CountryDTO(3,"c","cc","ccc"));
//        testc.add(new CountryDTO(4,"d","da","123"));
//        return testc;
//        return null;
    }



    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        CountryModel countryModel = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));

        // Update the fields of the countryModel with the fields from countryDTO

        countryRepository.save(countryModel);
        return countryDTO;
    }

//    public void updateCountry(Long id, CountryDTO countryDTO) {
//        CountryModel countryModel = countryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));
//
//        // Update the fields of the countryModel with the fields from countryDTO
//
//        countryRepository.save(countryModel);
//    }


    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new EntityNotFoundException("Country not found with ID: " + id);
        }
        countryRepository.deleteById(id);
    }


}
