package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {

     List<Student> selectAllStudent();

     void add(Student student);

     void edit(Student student);

    void delete(int id);

    List<Student> searchByName(String name);

    List<Student> sortByName();

}
