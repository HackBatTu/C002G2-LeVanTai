package ss7_abstract_interface.bai_tap.interface_resizeable;

import ss7_abstract_interface.bai_tap.interface_colorable.Colorable;

import java.util.Objects;

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
    public void resize(double percent) {}

    @Override
    public void howToColor() {

    }
}
