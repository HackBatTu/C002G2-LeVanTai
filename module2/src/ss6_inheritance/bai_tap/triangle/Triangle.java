package ss6_inheritance.bai_tap.triangle;

public class Triangle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle(){

    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return side1;
    }
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    public double getSide2() {
        return side2;
    }
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    public double getSide3() {
        return side3;
    }
    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getPerimeter(){
        return (side1+side2+side3)/2;
    }
    public double getArea(){
        return Math.sqrt(getPerimeter()*(getPerimeter()-this.side1)*(getPerimeter()-this.side2)*(getPerimeter()-this.side3));
    }

    @Override
    public String toString() {
        return "*Triangle : " +'\n' +
                "-color :" + color + '\n' +
                "-S =" + this.getArea() +'\n' +
                "-P =" + this.getPerimeter();
    }
}
