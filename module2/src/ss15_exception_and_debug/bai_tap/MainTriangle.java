package ss15_exception_and_debug.bai_tap;

import java.util.Scanner;

public class MainTriangle {
    public static void triangleExceptionCheck(double a , double b , double c) throws TriangleException{
        if(a<=0||b<=0||c<=0){
            throw new TriangleException("dont Triangle!");
        } else if (a + b <= c || a + c <= b || b + c <= a){
            throw new TriangleException("dont Triangle !");
        } else {
            System.out.println("this is Triangle ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the a : ");
            int a = sc.nextInt();
            System.out.print("Enter the b: ");
            int b = sc.nextInt();
            System.out.print("Enter the c: ");
            int c = sc.nextInt();
            try {
                MainTriangle.triangleExceptionCheck(a, b, c);
                return;
            } catch (TriangleException x) {
                x.printStackTrace();
            }
        }
    }
}
