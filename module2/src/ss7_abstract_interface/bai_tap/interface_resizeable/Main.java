package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Main {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10);

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("blue",x);
        shapes[1] = new Rectangle("red",x,x);
        shapes[2] = new Square("red",x);

        for (Shape a : shapes){
            if(a instanceof Circle) {
                shapes[0].resize(Math.random() * 100);
                System.out.println(((Circle) a).toString());
            }
            if(a instanceof Rectangle) {
                shapes[1].resize(Math.random() * 100);
                System.out.println(((Rectangle) a).toString());
            }
            if(a instanceof Square) {
                shapes[2].resize(Math.random() * 100);
                System.out.println(((Square) a).toString());

            }
        }



    }
}
