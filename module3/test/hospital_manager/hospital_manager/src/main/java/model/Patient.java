package model;

public class Patient {
    private String patientId;
    private String patientName;
    private Integer status;

    public Patient() {
    }

    public Patient(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public Patient(String patientId, String patientName, Integer status) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.status = status;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", status=" + status +
                '}';
    }
}
