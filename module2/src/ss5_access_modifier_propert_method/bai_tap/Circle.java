package ss5_access_modifier_propert_method.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";



    public Circle(){}

    public Circle(double r) {
        this.radius = r;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }
}
