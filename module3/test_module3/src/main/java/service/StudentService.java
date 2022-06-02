package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public List<Student> selectAllStudent() {
        return iStudentRepository.selectAllStudent();
    }

    @Override
    public void add(Student student) {
        if(student.getPoint()>0 && student.getPoint()<10){
            iStudentRepository.add(student);
        }

    }

    @Override
    public void editStudent(Student student) {
        iStudentRepository.edit(student);
    }

    @Override
    public void deleteStudent(int id) {
        iStudentRepository.delete(id);
    }

    @Override
    public List<Student> searchByName(String name) {
       return iStudentRepository.searchByName(name);
    }

    @Override
    public List<Student> sortByName() {
        return iStudentRepository.sortByName();

    }
}
