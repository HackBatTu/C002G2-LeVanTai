package model;

public class Student {
    private Integer studentId;
    private String studentName;
    private Integer classId;

    public Student() {
    }

    public Student(String studentName, Integer classId) {
        this.studentName = studentName;
        this.classId = classId;
    }

    public Student(Integer studentId, String studentName, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", classId=" + classId +
                '}';
    }
}
