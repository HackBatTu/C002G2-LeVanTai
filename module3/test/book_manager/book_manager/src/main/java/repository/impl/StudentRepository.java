package repository.impl;

import connection.DBConnect;
import model.Student;
import model.StudentClass;
import repository.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private DBConnect dbConnect = new DBConnect();
    private final String SELECT_ALL_STUDENT = " select * from `student` ";
    private final String SELECT_ALL_CLASS = " select * from `class` ";

    @Override
    public List<Student> getAllStudent() {
        Connection connection = dbConnect.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                int classId = resultSet.getInt("class_id");
                Student student = new Student(studentId,studentName,classId);
                students.add(student);
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
        return students;
    }

    @Override
    public List<StudentClass> getAllClass() {
        Connection connection = dbConnect.getConnection();
        List<StudentClass> studentClasses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int classId = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                StudentClass studentClass = new StudentClass(classId,className);
                studentClasses.add(studentClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentClasses;
    }
}
