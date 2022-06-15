package repository.impl;

import connection.DBConnect;
import model.Patient;
import repository.IPatientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements IPatientRepository {
    private DBConnect dbConnect = new DBConnect();
    private final String SELECT_ALL_PATIENT = " select * from `patient` " +
            " where `status` = 0 ";
    private final String UPDATE_PATIENT = " update `patient` " +
            " set `patient_name` = ? " +
            " where `patient_id` = ? ";

    @Override
    public List<Patient> getAllPatients() {
        Connection connection = dbConnect.getConnection();
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String patientId = resultSet.getString("patient_id");
                String patientName = resultSet.getString("patient_name");
                int status = resultSet.getInt("status");
                Patient patient = new Patient(patientId,patientName,status);
                patients.add(patient);
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
        return patients;
    }

    @Override
    public void editPatient(String patientId, String patientName) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT);
            preparedStatement.setString(1, patientName);
            preparedStatement.setString(2, patientId);
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
