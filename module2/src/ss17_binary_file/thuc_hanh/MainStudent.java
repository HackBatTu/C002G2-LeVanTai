package ss17_binary_file.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainStudent {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Lê Thị Luận", "Hà Nội"));
        students.add(new Student(2, "Lê Thị Phương", "Quảng trị"));
        students.add(new Student(3, "Lê Thị Hoàn", "Đà Nẵng"));
        students.add(new Student(4, "Lê Thị Bình", "Hà Nội"));
        students.add(new Student(5, "Lê Thị Trí", "lào"));
        writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("src/ss17_binary_file/thuc_hanh/student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
