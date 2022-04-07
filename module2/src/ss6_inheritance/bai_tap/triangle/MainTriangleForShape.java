package ss6_inheritance.bai_tap.triangle;

import java.util.Scanner;

public class MainTriangleForShape {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the a : ");
        double a = sc.nextDouble();
        System.out.print("Enter the b : ");
        double b = sc.nextDouble();
        System.out.print("Enter the c : ");
        double c = sc.nextDouble();
        System.out.print("Enter the color : ");
        String d = sc.nextLine();

        Shape shape = new Triangle(d,a,b,c);
        System.out.println("\n"+ shape + "\n"+"cạnh a: "+ a + ", cạnh b: " +b + ", cạnh c: "+c +"\n"+"-Color: "+d);
    }
}
