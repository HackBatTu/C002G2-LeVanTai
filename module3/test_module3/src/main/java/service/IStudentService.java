package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();

    void add(Student student);

    void editStudent(Student student);

    void deleteStudent(int id);

    List<Student> searchByName(String name);

    List<Student> sortByName();
}
