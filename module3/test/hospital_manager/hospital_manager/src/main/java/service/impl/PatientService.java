package service.impl;

import common.CheckRegex;
import model.MedicalRecord;
import model.Patient;
import repository.IMedicalRecordRepository;
import repository.IPatientRepository;
import repository.impl.MedicalRecordRepository;
import repository.impl.PatientRepository;
import service.IPatientService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientService implements IPatientService {
    private IPatientRepository patientRepository = new PatientRepository();
    private IMedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    @Override
    public Map<String, String> editPatient(String medicalRecordId,String patientId, String patientName) {
        Map<String, String> errMap = new HashMap<>();
        MedicalRecord medicalRecord = medicalRecordRepository.getMedicalRecordForEdit(medicalRecordId);
        if (!medicalRecord.getPatientId().equals(patientId)) {
            errMap.put("errPatientId", "Mã bệnh nhân không giống dữ liệu ban đầu.");
        }
        if (patientName == null || patientName.equals("")) {
            errMap.put("errPatientName", "Tên bệnh nhân không được để trống");
        } else if (CheckRegex.regexName(patientName)) {
            errMap.put("errPatientName", "Tên bệnh nhân không được chứa ký tự số");
        }
        if (errMap.isEmpty()) {
            patientRepository.editPatient(patientId,patientName);
        }
        return errMap;
    }
}
