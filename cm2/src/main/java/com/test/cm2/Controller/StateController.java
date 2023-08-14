package com.test.cm2.Controller;


import com.test.cm2.DTO.StateDTO;
//import com.test.cm2.Service.CountryService;
import com.test.cm2.Service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@RequiredArgsConstructor
public class StateController {
    private final StateService stateService;

    @PostMapping
    public ResponseEntity<StateDTO> createState(@RequestBody StateDTO stateDTO) {
        StateDTO createdState = stateService.createState(stateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdState);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> getStateById(@PathVariable Long id) {
        StateDTO stateDTO = stateService.getStateById(id);
        return ResponseEntity.ok(stateDTO);
    }

    @GetMapping
    public ResponseEntity<List<StateDTO>> getAllStates() {
        List<StateDTO> states = stateService.getAllStates();
        return ResponseEntity.ok(states);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateDTO> updateState(@PathVariable Long id, @RequestBody StateDTO stateDTO) {
        StateDTO updatedState = stateService.updateState(id, stateDTO);
        return ResponseEntity.ok(updatedState);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/{countryId}/states")
//    public ResponseEntity<List<StateDTO>> getAllStatesByCountryId(@PathVariable Long countryId) {
//        List<StateDTO> states = stateService.getAllStatesByCountryId(countryId);
//        return ResponseEntity.ok(states);
//    }


}




