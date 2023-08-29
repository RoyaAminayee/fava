package com.test.cm2.Controller;

import com.test.cm2.DTO.CountryDTO;
//import com.test.cm2.Exception.EntityNotFoundException;
import com.test.cm2.Exception.ExceptionHandlers;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.DTO.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {


    private final CountryService countryService;



    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        try {
            CountryDTO createdCountry = countryService.createCountry(countryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
        }
        catch (ExceptionHandlers.DuplicateError e ){
            throw e;
        }

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
//        CountryDTO countryDTO = countryService.getCountryById(id);
//        return ResponseEntity.ok(countryDTO);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        try {
            CountryDTO countryDTO = countryService.getCountryById(id);
            return ResponseEntity.ok(countryDTO);
        } catch (ExceptionHandlers.EntityNotFoundException e) {
            throw e; // Re-throw the exception to let the global handler catch it
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        try {
            countryService.deleteCountry(id);
            return ResponseEntity.noContent().build();
        }
        catch (ExceptionHandlers.RelatedEntityError e){
            throw e;
        }
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




    @GetMapping("/search")
    public List<CountryModel> getCountriesByCriteria(@RequestParam String fieldName, @RequestParam String operator, @RequestParam String value) {
        return countryService.getCountriesByCriteria(fieldName, operator, value);
    }


    @GetMapping(path = "/page")
    public ResponseEntity<Page<CountryDTO>> getAllCountries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "title") String sortBy, @RequestParam(defaultValue = "asc") String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        Page<CountryDTO> countryPage = countryService.getAllCountries(pageable);

        return ResponseEntity.ok(countryPage);
    }

}


