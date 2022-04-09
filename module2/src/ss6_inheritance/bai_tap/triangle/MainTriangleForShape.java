package ss6_inheritance.bai_tap.triangle;

import java.util.Scanner;

public class MainTriangleForShape {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the color : ");
        String color = sc.nextLine();
        System.out.print("Enter the a : ");
        double a = sc.nextDouble();
        System.out.print("Enter the b : ");
        double b = sc.nextDouble();
        System.out.print("Enter the c : ");
        double c = sc.nextDouble();


       Shape triangle = new Triangle(color,a,b,c);




        System.out.println("\n"+ triangle + "\n"+"-cạnh a: "+ a + ", cạnh b: " +b + ", cạnh c: "+c +"\n"+"-Color :" +color);
    }
}
