package model;

import java.util.Date;

public class MedicalRecord {
    private String medicalRecordId;
    private String patientId;
    private Date hospitalizedDay;
    private Date dischargeDay;
    private String hospitalizedReason;
    private Integer status;

    public MedicalRecord() {
    }

    public MedicalRecord(String medicalRecordId, String patientId, Date hospitalizedDay, Date dischargeDay, String hospitalizedReason) {
        this.medicalRecordId = medicalRecordId;
        this.patientId = patientId;
        this.hospitalizedDay = hospitalizedDay;
        this.dischargeDay = dischargeDay;
        this.hospitalizedReason = hospitalizedReason;
    }

    public MedicalRecord(String medicalRecordId, String patientId, Date hospitalizedDay, Date dischargeDay, String hospitalizedReason, Integer status) {
        this.medicalRecordId = medicalRecordId;
        this.patientId = patientId;
        this.hospitalizedDay = hospitalizedDay;
        this.dischargeDay = dischargeDay;
        this.hospitalizedReason = hospitalizedReason;
        this.status = status;
    }

    public String getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(String medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getHospitalizedDay() {
        return hospitalizedDay;
    }

    public void setHospitalizedDay(Date hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public Date getDischargeDay() {
        return dischargeDay;
    }

    public void setDischargeDay(Date dischargeDay) {
        this.dischargeDay = dischargeDay;
    }

    public String getHospitalizedReason() {
        return hospitalizedReason;
    }

    public void setHospitalizedReason(String hospitalizedReason) {
        this.hospitalizedReason = hospitalizedReason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "medicalRecordId='" + medicalRecordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", hospitalizedDay=" + hospitalizedDay +
                ", dischargeDay=" + dischargeDay +
                ", hospitalizedReason='" + hospitalizedReason + '\'' +
                ", status=" + status +
                '}';
    }
}
