package ss6_inheritance.bai_tap.triangle;

public class Shape {
    protected  String color = "red";

    public Shape(){

    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
