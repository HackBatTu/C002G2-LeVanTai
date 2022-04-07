package ss6_inheritance.bai_tap.circle_cylinder;

public class Circle {
    protected double radius = 1.0;
    protected String color = "green";

    public Circle(){};

    public Circle(double radius , String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle :" +"\n"+
                "radius=" + radius +"\n"+
                "color='" + color + '\'';
    }
}
