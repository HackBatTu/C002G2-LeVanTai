package service;

import model.Patient;

import java.util.List;
import java.util.Map;

public interface IPatientService {
    List<Patient> getAllPatients();

    Map<String, String> editPatient(String medicalRecordId,String patientId, String patientName);
}
