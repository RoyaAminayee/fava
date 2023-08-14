package com.test.cm2.Controller;

import com.test.cm2.DTO.CountryDTO;
//import com.test.cm2.Model.BaseEntity;
import com.test.cm2.Model.CountryModel;
//import com.test.cm2.Service.CountryService;
//import com.test.cm2.Service.GenericService;
//import com.test.cm2.Service.RoyaService;
import com.test.cm2.Service.CountryService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

//    @Qualifier("GenericService")
//    protected GenericService<CountryDTO, Long> genericService;
//    private final RoyaService royaService;
    private final CountryService countryService;
//    @Autowired
//    private  final CountryService countryService;
//    private final CountryService countryService;
//
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

//    @GetMapping("/{id}")
//    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
//        CountryDTO countryDTO = genericService.getById(id);
//        return ResponseEntity.ok(countryDTO);
//    }


    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
//    	return ResponseEntity.ok("salam");
    }

//    @GetMapping
//    public ResponseEntity<List<CountryModel>> getAllRoya() {
//        List<CountryModel> countries = royaService.getAll();
//        return ResponseEntity.ok(countries);
////    	return ResponseEntity.ok("salam");
//    }


//    @GetMapping
//    public ResponseEntity<List<CountryModel>> getAllCountries() {
//        List<CountryModel> countries = countryService.getAll();
//        return ResponseEntity.ok(countries);
////    	return ResponseEntity.ok("salam");
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        CountryDTO updatedCountry = countryService.updateCountry(id, countryDTO);
        return ResponseEntity.ok(updatedCountry);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
//        genericService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/search")
//    public List<CountryModel> getCountriesByCriteria(
//            @RequestParam String fieldName,
//            @RequestParam String operator,
//            @RequestParam String value) {
//        return countryService.getCountriesByCriteria(fieldName, operator, value);
//    }
//

//
//    @GetMapping(path="/page")
//    public ResponseEntity<Page<CountryDTO>> getAllCountries(@RequestParam(defaultValue = "0") int page,
//                                                            @RequestParam(defaultValue = "2") int size,
//                                                            @RequestParam(defaultValue = "title") String sortBy,
//                                                            @RequestParam(defaultValue = "asc") String sortOrder) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
//        Page<CountryDTO> countryPage = countryService.getAllCountries(pageable);
//
//        return ResponseEntity.ok(countryPage);
//    }
//



}


