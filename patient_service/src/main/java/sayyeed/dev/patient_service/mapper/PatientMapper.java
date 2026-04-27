package sayyeed.dev.patient_service.mapper;

import sayyeed.dev.patient_service.dto.PatientRequestDTO;
import sayyeed.dev.patient_service.dto.PatientResponseDTO;
import sayyeed.dev.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDto = new PatientResponseDTO();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientResponseDto;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.se
    }
}
