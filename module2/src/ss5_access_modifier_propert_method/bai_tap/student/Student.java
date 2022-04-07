package ss5_access_modifier_propert_method.bai_tap.student;

import javafx.scene.shape.Circle;

public class Student {
    String name = "John";
    String classes = "C02";

    public Student(){}
    public Student(String name , String classes){
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }


    @Override
    public String toString() {
        return "Student: \n" +
                "name : " + name + '\n' +
                "classes: " + classes + '\n'
                ;
    }
}
