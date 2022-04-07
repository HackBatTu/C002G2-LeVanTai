package ss5_access_modifier_propert_method.bai_tap.circle;

import ss5_access_modifier_propert_method.bai_tap.circle.Circle;

import java.util.Scanner;

public class MainCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the Radius: ");
        double r = sc.nextDouble();

        Circle circle = new Circle(r);
        circle.setColor("red");

        System.out.print(circle + "\n"+ "-S = " + circle.getArea());
    }
}
