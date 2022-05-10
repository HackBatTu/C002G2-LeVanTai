package bai_tap_lam_them.bai_3_exam;

import java.util.*;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME_STUDENT = "src/bai_tap_lam_them/bai_3_exam/student.csv";
    private static final String FILE_NAME_TEACHER = "src/bai_tap_lam_them/bai_3_exam/teacher.csv";

    public static void main(String[] args) {
        while (true) {
            System.out.println("Main menu\n" +
                    "1. Student\n" +
                    "2. Teacher\n" +
                    "0. Exit");
            System.out.print("Choice: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    choiceStudentManagement();
                    break;
                case 2:
                    choiceTeacherManagement();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    private static void choiceStudentManagement() {
        while (true) {
            System.out.println("Student Management\n" +
                    "1. Add new student\n" +
                    "2. Display student\n" +
                    "3. Search student by name\n" +
                    "4. Sort by name\n" +
                    "0. Return main menu");
            System.out.print("Choice: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    searchStudentByName();
                    break;
                case 4:
                    sortByPoint();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    private static void choiceTeacherManagement() {
        while (true) {
            System.out.println("Student Management\n" +
                    "1. Add new teacher\n" +
                    "2. Display teacher\n" +
                    "0. Return main menu");
            System.out.print("Choice: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    addNewTeacher();
                    break;
                case 2:
                    displayTeacher();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    public static void displayStudent() {
        students = FileService.readStudent(FILE_NAME_STUDENT);
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Student list is empty!");
        }
    }

    public static void addNewStudent() {
        students = FileService.readStudent(FILE_NAME_STUDENT);

        if (students.isEmpty()) {
            Person.setCountId(1);
        } else {
            int max = students.get(0).getId();
            for (Student student : students) {
                if (student.getId() > max) {
                    max = student.getId();
                }
            }
            Person.setCountId(max);
            if (Person.getCountId() == null) {
                Person.setCountId(1);
            } else {
                Person.setCountId(Person.getCountId() + 1);
            }
        }

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Point: ");
        int point = CheckRegex.checkRegexPoint();
        students.add(new Student(Person.getCountId(), name, point));

        FileService.writeStudent(FILE_NAME_STUDENT, students);
    }

    public static void searchStudentByName() {
        students = FileService.readStudent(FILE_NAME_STUDENT);

        System.out.print("Enter name for search: ");
        String name = sc.nextLine();
        if (checkNameExists(name)) {
            for (Student student : students) {
                if (student.getName().contains(name.toLowerCase())) {
                    System.out.println(student);
                }
            }
        } else {
            try {
                throw new MySearchException("Name is not exists!");
            } catch (MySearchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Kiểm tra xem tên có tồn tại trong list không?
     */
    private static boolean checkNameExists(String name) {
        students = FileService.readStudent(FILE_NAME_STUDENT);

        for (Student student : students) {
            if (student.getName().contains(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void sortByPoint() {
        students = FileService.readStudent(FILE_NAME_STUDENT);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPoint() - o2.getPoint();
            }
        });
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void addNewTeacher() {
        teachers = FileService.readTeacher(FILE_NAME_TEACHER);

        if (teachers.isEmpty()) {
            Person.setCountId(1);
        } else {
            int max = teachers.get(0).getId();
            for (Teacher teacher : teachers) {
                if (teacher.getId() > max) {
                    max = teacher.getId();
                }
            }
            Person.setCountId(max);
            if (Person.getCountId() == null) {
                Person.setCountId(1);
            } else {
                Person.setCountId(Person.getCountId() + 1);
            }
        }

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Salary: ");
        double salary = Double.parseDouble(sc.nextLine());
        teachers.add(new Teacher(Person.getCountId(), name, salary));

        FileService.writeTeacher(FILE_NAME_TEACHER, teachers);
    }

    public static void displayTeacher() {
        teachers = FileService.readTeacher(FILE_NAME_TEACHER);

        if (!teachers.isEmpty()) {
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        } else {
            System.out.println("Teacher list is empty!");
        }
    }
}
