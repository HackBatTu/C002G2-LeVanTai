package repository;

import model.Student;
import model.StudentClass;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudent();

    List<StudentClass> getAllClass();
}
