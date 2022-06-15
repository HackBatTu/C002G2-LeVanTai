package service.impl;

import model.MedicalRecord;
import repository.IMedicalRecordRepository;
import repository.impl.MedicalRecordRepository;
import service.IMedicalRecordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordService implements IMedicalRecordService {
    private IMedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.getAllMedicalRecords();
    }

    @Override
    public void deleteMedicalRecord(String idDelete) {
        medicalRecordRepository.deleteMedicalRecord(idDelete);
    }

    @Override
    public MedicalRecord getMedicalRecordForEdit(String idEdit) {
        return medicalRecordRepository.getMedicalRecordForEdit(idEdit);
    }

    @Override
    public Map<String, String> editMedicalRecord(MedicalRecord medicalRecord) {
        Map<String, String> errMap = new HashMap<>();
        if (medicalRecord.getHospitalizedReason() == null || medicalRecord.getHospitalizedReason().equals("")) {
            errMap.put("errHospitalizedReason", "Lý do nhập viện không được để trống");
        }
        if (medicalRecord.getHospitalizedDay().after(medicalRecord.getDischargeDay())) {
            errMap.put("errDischargeDay", "Ngày xuất viện không được nhỏ hơn ngày nhập viện");
        }
        if (errMap.isEmpty()) {
            medicalRecordRepository.editMedicalRecord(medicalRecord);
        }
        return errMap;
    }
}
