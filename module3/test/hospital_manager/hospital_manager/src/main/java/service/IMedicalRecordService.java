package service;

import model.MedicalRecord;

import java.util.List;
import java.util.Map;

public interface IMedicalRecordService {
    List<MedicalRecord> getAllMedicalRecords();

    void deleteMedicalRecord(String idDelete);

    MedicalRecord getMedicalRecordForEdit(String idEdit);

    Map<String, String> editMedicalRecord(MedicalRecord medicalRecord);
}
