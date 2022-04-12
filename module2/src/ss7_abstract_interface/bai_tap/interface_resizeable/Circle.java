package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Circle extends Shape{
    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle: " +
                "radius: " + radius +
                "Area" + this.getArea() + "\n" +
                "Per" + this.getPerimeter() + "\n" +
                ']';
    }
    @Override
    public void resize(double percent) {
        this.radius += percent;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
