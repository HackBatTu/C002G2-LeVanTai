package repository;

import model.Patient;

import java.util.List;

public interface IPatientRepository {
    List<Patient> getAllPatients();

    void editPatient(String patientId, String patientName);
}
