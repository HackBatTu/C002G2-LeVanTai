package ss7_abstract_interface.bai_tap.interface_colorable;

import ss7_abstract_interface.bai_tap.interface_resizeable.Circle;
import ss7_abstract_interface.bai_tap.interface_resizeable.Rectangle;
import ss7_abstract_interface.bai_tap.interface_resizeable.Shape;
import ss7_abstract_interface.bai_tap.interface_resizeable.Square;

public class MainColorable {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10);

        Circle circle = new Circle("blue",x);
        Rectangle rectangle = new Rectangle("red",x,x);
        Square square = new Square("red",x);
        Shape[] shapes = new Shape[]{circle,rectangle,square};
        for (Shape a : shapes){
            System.out.println(a);
        }
        circle.howToColor();
        rectangle.howToColor();
        square.howToColor();
    }
}
