package test_module2_java.file_io_txt;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {


    //        private final static String PATH_STUDENT = "src\\ss4_class_object\\student_manager1\\data\\student.csv";
//        private final static String PATH_TEACHER = "src\\ss4_class_object\\student_manager1\\data\\teacher.csv";
//        // cách 1
//        public static void writeStudentToCSV(List<Student> studentList,Boolean flag){
//            File file = new File(PATH_STUDENT);
//            FileWriter fileWriter =null;
//            BufferedWriter bufferedWriter = null;
//            try {
//                fileWriter = new FileWriter(file,flag);
//                bufferedWriter =new BufferedWriter(fileWriter);
//                for (Student student: studentList) {
//                    bufferedWriter.write(student.getInfoToCSV());
//                    bufferedWriter.newLine();
//                }
//                bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    // cách 2
// viết hàm chung
    private static void writeDatToCSV(List<String> stringList, String pathFile, Boolean flag) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, flag);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // hàm riêng têacher
//        public static void writeTeachertToCSV1(List<Teacher> teacherList, Boolean flag) {
//            List<String> stringList = new ArrayList<>();
//            for (Teacher teacher : teacherList) {
//                stringList.add(teacher.toString());
//            }
//            writeDatToCSV(stringList, PATH_TEACHER, flag);
//        }

//        // hàm riêng student
//        public static void writeStudentToCSV1(List<Student> studentList, Boolean flag) {
//            List<String> stringList = new ArrayList<>();
//            for (Student student : studentList) {
//                stringList.add(student.getInfoToCSV());
//            }
//            writeDatToCSV(stringList, PATH_STUDENT, flag);
//        }


    //cách 1
//        public static List<Student> readFileCsvToListStudent() {
//            List<Student> studentList = new ArrayList<>();
//            File file = new File(PATH_STUDENT);
//            FileReader fileReader = null;
//            BufferedReader bufferedReader = null;
//            try {
//                fileReader = new FileReader(file);
//                bufferedReader = new BufferedReader(fileReader);
//                String line = null;
//                String[] array = null;
//                Student student = null;
//                while ((line = bufferedReader.readLine()) != null) {
//                    array = line.split(",");
//                    student = new Student(Integer.parseInt(array[0]), array[1],
//                            array[2], Integer.parseInt(array[3]));
//                    studentList.add(student);
//                }
//                bufferedReader.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return studentList;
//        }
    // cách 2 hàm chung
    private static List<String> readFileCsvToListStrinng(String pathFile) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
//        public static List<Student> readFileCsvToListStudent1() {
//            List<String> stringList = readFileCsvToListStrinng(PATH_STUDENT);
//            List<Student> studentList = new ArrayList<>();
//            String[] array = null;
//            Student student = null;
//            // chuyển listString => listStudent
//            for (String str: stringList) {
//                array = str.split(",");
//                student = new Student(Integer.parseInt(array[0]), array[1],
//                        array[2], Integer.parseInt(array[3]));
//                studentList.add(student);
//            }
//            return studentList;
//        }
}
