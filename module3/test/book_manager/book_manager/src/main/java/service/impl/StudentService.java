package service.impl;

import model.Student;
import model.StudentClass;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public List<StudentClass> getAllClass() {
        return studentRepository.getAllClass();
    }

}
