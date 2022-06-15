package repository;

import model.MedicalRecord;

import java.util.List;

public interface IMedicalRecordRepository {
    List<MedicalRecord> getAllMedicalRecords();

    void deleteMedicalRecord(String idDelete);

    MedicalRecord getMedicalRecordForEdit(String idEdit);

    void editMedicalRecord(MedicalRecord medicalRecord);
}
