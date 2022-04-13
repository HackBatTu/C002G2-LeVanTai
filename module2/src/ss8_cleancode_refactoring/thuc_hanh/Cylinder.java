package ss8_cleancode_refactoring.thuc_hanh;

import java.util.Scanner;

public class Cylinder {
    public static double getVolume(double radius, double height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(double radius) {
        return 2 * Math.PI  * radius;
    }

    private static double getBaseArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius : ");
        double radius = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the height : ");
        double height = Integer.parseInt(sc.nextLine());

        System.out.println("Volume =  " + Cylinder.getVolume(radius,height));
        System.out.println("Perimeter= "+Cylinder.getPerimeter(radius));
        System.out.println("BaseArea= " +Cylinder.getBaseArea(radius));

    }
}
