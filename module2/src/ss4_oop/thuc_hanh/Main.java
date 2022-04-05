package ss4_oop.thuc_hanh;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width : ");
        double width = sc.nextDouble();
        System.out.println("Enter the height: ");
        double height = sc.nextDouble();
        ClassRectangle rectangle = new ClassRectangle(width,height);

        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }
}
