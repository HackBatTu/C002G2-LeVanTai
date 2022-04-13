package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Square extends Shape{
    private int width ;

    public Square(int width) {
        this.width = width;
    }

    public Square(String color, int width) {
        super(color);
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getArea() {
        return width *width;
    }
    @Override
    public double resize(double percent) {
        this.width *= percent;
        return percent;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                "area: "+getArea()+
                '}';
    }
}

