package demo;

public class Student {
    int rollno;
    String name;
    static String college = "CodeGym Đà Nẵng";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " - " + name + " - " + college);
    }

    public static void main(String args[]) {
        Student s1 = new Student(1, "Lê Văn Phúc");
        Student s2 = new Student(2, "Trà Văn Luận");

        s1.display();
        s2.display();
    }
}
