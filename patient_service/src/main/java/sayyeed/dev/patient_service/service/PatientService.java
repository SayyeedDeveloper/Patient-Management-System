package sayyeed.dev.patient_service.service;

import org.springframework.stereotype.Service;
import sayyeed.dev.patient_service.dto.PatientRequestDTO;
import sayyeed.dev.patient_service.dto.PatientResponseDTO;
import sayyeed.dev.patient_service.mapper.PatientMapper;
import sayyeed.dev.patient_service.model.Patient;
import sayyeed.dev.patient_service.repository.PatientRepository;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientCreateDTO) {
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientCreateDTO));

        return PatientMapper.toDTO(newPatient);
    }
}
