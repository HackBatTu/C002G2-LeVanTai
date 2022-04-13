package ss7_abstract_interface.bai_tap.interface_resizeable;

import ss7_abstract_interface.bai_tap.interface_colorable.Colorable;

public class Shape implements Resizeable, Colorable {
    private String color = "red";

    public Shape() {
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

    @Override
    public double resize(double percent) {
        return percent;
    }

    @Override
    public void howToColor() {

    }
}
