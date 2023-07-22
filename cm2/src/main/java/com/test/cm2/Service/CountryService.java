package com.test.cm2.Service;

import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

//    @Autowired
//    private CountryMapper countryMapper;


//    public CountryDTO createCountry(CountryDTO countryDTO) {
//        CountryModel countryModel = countryMapper.toEntity(countryDTO);
//        CountryModel savedCountry = countryRepository.save(countryModel);
//        return countryMapper.toDTO(savedCountry);
//    }
//
//
//
//    public CountryDTO getCountryById(Long id) {
//        CountryModel countryModel = countryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));
//        return countryMapper.toDTO(countryModel);
//    }

//    public CountryServiceClass() {
//
//    }


    public List<CountryDTO> getAllCountries() {
        List<CountryModel> countryModels = countryRepository.findAll();
//        return countryMapper.toDTOList(countryModels);
        List<CountryDTO> testc = new ArrayList<>();
//        testc.add(new CountryDTO(1,"a","aa","aaa"));
//        testc.add(new CountryDTO(2,"b","bb","bbb"));
//        testc.add(new CountryDTO(3,"c","cc","ccc"));
//        testc.add(new CountryDTO(4,"d","da","123"));
        return testc;
    }



//
//    public void updateCountry(Long id, CountryDTO countryDTO) {
//        CountryModel countryModel = countryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));
//
//        // Update the fields of the countryModel with the fields from countryDTO
//
//        countryRepository.save(countryModel);
//    }
//
//
//    public void deleteCountry(Long id) {
//        if (!countryRepository.existsById(id)) {
//            throw new EntityNotFoundException("Country not found with ID: " + id);
//        }
//        countryRepository.deleteById(id);
//    }

}
