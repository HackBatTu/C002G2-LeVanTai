package bai_tap_lam_them.bai_3_exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String COMMA = ",";

    private static void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStudent(String pathFile, List<Student> students) {
        List<String> strings = new ArrayList<>();

        for (Student student : students) {
            strings.add(student.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeTeacher(String pathFile, List<Teacher> teachers) {
        List<String> strings = new ArrayList<>();

        for (Teacher teacher : teachers) {
            strings.add(teacher.convertLine());
        }
        writeToFile(pathFile, strings);
    }


    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Student> readStudent(String pathFile) {
        List<Student> students = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            students.add(new Student(Integer.parseInt(lines[0]), lines[1], Integer.parseInt(lines[2])));
        }
        return students;
    }

    public static List<Teacher> readTeacher(String pathFile) {
        List<Teacher> teachers = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            teachers.add(new Teacher(Integer.parseInt(lines[0]),lines[1],Double.parseDouble(lines[2])));
        }
        return teachers;
    }

}
