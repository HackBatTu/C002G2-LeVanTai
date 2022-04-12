package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Rectangle extends Shape{
    private int height ;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle(String color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public double getArea() {
        return width * this.height;
    }

    public double getPerimeter() {
        return 2 * (width + this.height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                "Area : "+ getArea()+
                "Primater : "+ getPerimeter()+
                '}';
    }
    @Override
    public void resize(double percent) {
        this.height += percent;
        this.width  += percent;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
