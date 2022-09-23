package demo;

public class StudentFunction {
    int rollno;
    String name;
    static String college = "CodeGym Đà Nẵng";

    static void change() {
        college = "CodeGym C0222G2 Đà Nẵng";
    }

    StudentFunction(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " - " + name + " - " + college);
    }

    public static void main(String args[]) {

        StudentFunction.change();

        StudentFunction s1 = new StudentFunction(111, "Lê Văn Phúc");
        StudentFunction s2 = new StudentFunction(222, "Lê Thị Bình");
        StudentFunction s3 = new StudentFunction(333, "Trà Văn Luận");

        s1.display();
        s2.display();
        s3.display();
    }
}
