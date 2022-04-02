package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the a: ");
        int a = sc.nextInt();
        System.out.print("Enter the b: ");
        int b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        if(a==0 || b ==0){
            System.out.println("No greatest common divior");
        }
        while (a!=b){
            if(a>b){
                a = a-b;
            }else {
                b= b-a;
            }
        }System.out.println("Greatest common divior: " +a );

    }
}
