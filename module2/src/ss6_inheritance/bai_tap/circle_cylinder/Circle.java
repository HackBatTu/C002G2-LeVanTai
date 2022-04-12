package ss6_inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "green";
    private double area = Math.PI * Math.pow(radius, 2);


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
        return area;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle :" +"\n"+
                "radius= " + this.radius +"\n"+
                "color= " + this.color ;
    }
}
