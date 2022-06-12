package service;

import model.Student;
import model.StudentClass;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();

    List<StudentClass> getAllClass();
}
