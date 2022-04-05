package ss4_oop.bai_tap;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print(" Enter the a");
        double a = sc.nextDouble();
        System.out.print(" Enter the b");
        double b = sc.nextDouble();
        System.out.print(" Enter the c");
        double c = sc.nextDouble();
        QuadraticEquation q = new QuadraticEquation(a,b,c);
//        if (q.getDiscriminant()>0){
//            System.out.println(q.getRoot1() + " " +q.getRoot2());
//        }else if(q.getDiscriminant()==0){
//            System.out.println(q.getRoot1());
//        } else {
//            System.out.println( "The equation has no roots" + 0);
//        }
        System.out.println(q.Culation());
    }
}
