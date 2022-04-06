package ss4_oop.bai_tap.quadratic_equation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print(" Enter the a: ");
        double a = sc.nextDouble();
        System.out.print(" Enter the b: ");
        double b = sc.nextDouble();
        System.out.print(" Enter the c: ");
        double c = sc.nextDouble();

        QuadraticEquation q = new QuadraticEquation(a,b,c);

        System.out.println(q.Culation());
    }
}
