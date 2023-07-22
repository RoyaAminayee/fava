package com.test.cm2.Controller;

import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
//@RequiredArgsConstructor
public class CountryController {

    @Autowired
    CountryService countryService;
//    private final CountryService countryService;

//    @Autowired
//    public CountryController(CountryService countryService){
//        this.countryService=countryService;
//    }

//
//    public CountryControlller(CountryServiceClass countryService) {
//        this.countryService = countryService;
//
//    }
//    @Autowired
//    public void setCountryService(CountryService countryService) {
//        this.countryService = countryService;
//    }
    /*
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
    */

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
//    	return ResponseEntity.ok("salam");
    }

    /*
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
    */
}
