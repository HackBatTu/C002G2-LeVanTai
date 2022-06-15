package repository.impl;

import connection.DBConnect;
import model.MedicalRecord;
import repository.IMedicalRecordRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecordRepository implements IMedicalRecordRepository {
    private DBConnect dbConnect = new DBConnect();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final String SELECT_ALL_MEDICAL_RECORD = " select * from `medical_record` " +
            " where `status` = 0 ";
    private final String DELETE_MEDICAL_RECORD = " update `medical_record` " +
            " set `status` = 1 " +
            " where `medical_record_id` = ?; ";
    private final String GET_MEDICAL_RECORD = " select * from `medical_record` " +
            " where `medical_record_id` = ? ";
    private final String EDIT_MEDICAL_RECORD = " update `medical_record` " +
            " set `hospitalized_day` = ?, `discharge_day` = ?, `hospitalized_reason` = ? " +
            " where `medical_record_id` = ?; ";

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        Connection connection = dbConnect.getConnection();
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEDICAL_RECORD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String medicalRecordId = resultSet.getString("medical_record_id");
                String patientId = resultSet.getString("patient_id");
                Date hospitalizedDay = resultSet.getDate("hospitalized_day");
                Date dischargeDay = resultSet.getDate("discharge_day");
                String hospitalizedReason = resultSet.getString("hospitalized_reason");
                int status = resultSet.getInt("status");
                MedicalRecord medicalRecord = new MedicalRecord(medicalRecordId, patientId, hospitalizedDay, dischargeDay, hospitalizedReason, status);
                medicalRecords.add(medicalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medicalRecords;
    }

    @Override
    public void deleteMedicalRecord(String idDelete) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MEDICAL_RECORD);
            preparedStatement.setString(1, idDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public MedicalRecord getMedicalRecordForEdit(String idEdit) {
        MedicalRecord medicalRecord = new MedicalRecord();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MEDICAL_RECORD);
            preparedStatement.setString(1, idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String medicalRecordId = resultSet.getString("medical_record_id");
                String patientId = resultSet.getString("patient_id");
                Date hospitalizedDay = resultSet.getDate("hospitalized_day");
                Date dischargeDay = resultSet.getDate("discharge_day");
                String hospitalizedReason = resultSet.getString("hospitalized_reason");
                int status = resultSet.getInt("status");
                medicalRecord = new MedicalRecord(medicalRecordId, patientId, hospitalizedDay, dischargeDay, hospitalizedReason, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medicalRecord;
    }

    @Override
    public void editMedicalRecord(MedicalRecord medicalRecord) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_MEDICAL_RECORD);
            preparedStatement.setString(1, simpleDateFormat.format(medicalRecord.getHospitalizedDay()));
            preparedStatement.setString(2, simpleDateFormat.format(medicalRecord.getDischargeDay()));
            preparedStatement.setString(3, medicalRecord.getHospitalizedReason());
            preparedStatement.setString(4, medicalRecord.getMedicalRecordId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
