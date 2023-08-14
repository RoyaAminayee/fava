package com.test.cm2.Controller;

import com.test.cm2.DTO.CityDTO;
import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.DTO.InstituteDTO;
import com.test.cm2.Model.Institute;
//import com.test.cm2.Service.CountryService;
import com.test.cm2.Service.InstituteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


//    @PostMapping
//    public ResponseEntity<InstituteDTO> createInstitute(@RequestBody InstituteDTO instituteDTO) {
//        InstituteDTO createdInstitute = instituteService.createInstitute(instituteDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstitute);
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<InstituteDTO> updateInstitute(@PathVariable Long id, @RequestBody InstituteDTO instituteDTO) {
//        InstituteDTO updatedInstitute = instituteService.updateInstitute( id, instituteDTO);
//        return ResponseEntity.ok(updatedInstitute);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CountryDTO> getInstituteById(@PathVariable Long id) {
//        InstituteDTO instituteDTO = instituteService.getInstituteById(id);
//        return ResponseEntity.ok(instituteDTO);
//    }
//
//


//        @PutMapping("/{id}/cities")
//        public ResponseEntity<InstituteDTO> updateInstituteCities(
//                @PathVariable Long id,
//                @RequestBody List<Long> cityIds
//        ) {
//            InstituteDTO updatedInstitute = instituteService.updateInstituteCities(id, cityIds);
//            return ResponseEntity.ok(updatedInstitute);
//        }
//    }

//    @PutMapping("/{id}/cities")
//    public ResponseEntity<InstituteDTO> updateInstituteCities(
//            @PathVariable Long id,
//            @RequestBody List<Long> cityIds
//    ) {
//        InstituteDTO updatedInstitute = instituteService.updateInstituteCities(id, cityIds);
//        return ResponseEntity.ok(updatedInstitute);
//    }

//    @PostMapping("/{instituteId}/add-cities")
//    public ResponseEntity<InstituteDTO> addCitiesToInstitute(
//            @PathVariable Long instituteId,
//            @RequestBody InstituteDTO instituteDTO) {
//        InstituteDTO updatedInstitute = instituteService.addCitiesToInstitute(instituteId, instituteDTO.getCityIds());
//        return ResponseEntity.ok(updatedInstitute);
//    }
}



