package ss6_inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height = 3.0;
    Cylinder(){

    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getV(){
        return getRadius()*getRadius()*height*Math.PI;
    }

    @Override
    public String toString() {
        return "Cylinder: " +
                "height =" + height +"\n"+
                "Radius = "+ getRadius() +"\n"+
                "V = " +getV()+"\n"+
                "Color : "+getColor();


    }
}
