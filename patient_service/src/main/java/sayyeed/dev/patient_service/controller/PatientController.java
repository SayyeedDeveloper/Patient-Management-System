package sayyeed.dev.patient_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sayyeed.dev.patient_service.dto.PatientRequestDTO;
import sayyeed.dev.patient_service.dto.PatientResponseDTO;
import sayyeed.dev.patient_service.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO newPatientRequest) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(newPatientRequest);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
