package com.test.cm2.Controller;

import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {



//    @Autowired
    private  final CountryService countryService;
//    private final CountryService countryService;

//    @Autowired
//    public CountryController(CountryService countryService){
//        this.countryService=countryService;
//    }

//
//    public CountryController(CountryServiceClass countryService) {
//        this.countryService = countryService;
//
//    }
//    @Autowired
//    public void setCountryService(CountryService countryService) {
//        this.countryService = countryService;
//    }

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        CountryDTO createdCountry = countryService.createCountry(countryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        CountryDTO countryDTO = countryService.getCountryById(id);
        return ResponseEntity.ok(countryDTO);
    }


    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
//    	return ResponseEntity.ok("salam");
    }


    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        CountryDTO updatedCountry = countryService.updateCountry(id, countryDTO);
        return ResponseEntity.ok(updatedCountry);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<CountryModel> getCountriesByCriteria(
            @RequestParam String fieldName,
            @RequestParam String operator,
            @RequestParam String value) {
        return countryService.getCountriesByCriteria(fieldName, operator, value);
    }

}


