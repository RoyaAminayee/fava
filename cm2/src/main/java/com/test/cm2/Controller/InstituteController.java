package com.test.cm2.Controller;

import com.test.cm2.DTO.InstituteDTO;
//import com.test.cm2.Service.CountryService;
import com.test.cm2.Service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/institute")
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping
    public ResponseEntity<List<InstituteDTO>> getAllInstitute() {
        List<InstituteDTO> institutes = instituteService.getAllInstitutes();
        return ResponseEntity.ok(institutes);
    }
////

    @GetMapping("/{id}")
    public ResponseEntity<InstituteDTO> getInstituteById(@PathVariable Long id) {
        InstituteDTO instituteDTO = instituteService.getInstituteById(id);
        return ResponseEntity.ok(instituteDTO);
    }


    @PostMapping
    public void createInstitute(@RequestBody InstituteDTO instituteDTO) {
        instituteService.createInstitute(instituteDTO);
    }


    @DeleteMapping("/{instituteId}/{cityIds}")
    public void deleteCitiesFromInstitute(
            @PathVariable Long instituteId,
            @PathVariable Set<Long> cityIds) {
        instituteService.deleteCitiesFromInstitute(instituteId, cityIds);
    }

    @PutMapping("/{instituteId}/{cityIds}")
    public void updateCitiesOfInstitute(
            @PathVariable Long instituteId,
            @PathVariable Set<Long> cityIds) {
        instituteService.updateCitiesOfInstitute(instituteId, cityIds);
    }

}



