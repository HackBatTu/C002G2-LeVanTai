package ss5_access_modifier_propert_method.bai_tap;

import java.util.Scanner;

public class MainCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the Radius: ");
        double r = sc.nextDouble();
        Circle circle = new Circle(r);
        System.out.print(" S = " + circle.getArea());
    }
}
