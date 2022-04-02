package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class CheckSNT {
    public static void main(String[] args) {
        System.out.print("Enter the number");
        Scanner sc = new Scanner(System.in);
        int numBer= sc.nextInt();
        if(numBer<2){
            System.out.print(numBer +"is not a prime");
        }else {
            int i=2;
            boolean check = true;
            while (i<= Math.sqrt(numBer)){
                if(numBer%i==0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.print(numBer + " is a prime");
            }else {
                System.out.print(numBer+ " not is a prime");
            }
        }
    }
}
