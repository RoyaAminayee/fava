package com.test.cm2.Controller;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.DTO.Service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
        CityDTO createdCity = cityService.createCity(cityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CityDTO> getCityById(@PathVariable Long id) {
//        CityDTO cityDTO = cityService.getCityById(id);
//        return ResponseEntity.ok(cityDTO);
//    }

//    @GetMapping
//    public ResponseEntity<List<CityDTO>> getAllCities(InstituteDTO instituteDTO) {
//        cityService.getAllCities(instituteDTO);
//        return ResponseEntity.ok(cities);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        CityDTO updatedCity = cityService.updateCity(id, cityDTO);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }


}


