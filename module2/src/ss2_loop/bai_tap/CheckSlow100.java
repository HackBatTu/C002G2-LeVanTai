package ss2_loop.bai_tap;

import java.util.Scanner;

public class CheckSlow100 {
    public static void main(String[] args) {
        int number = 0;
        while (number<100) {
            boolean check = true;
            if (number < 2) {
                check = false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                }
            }
            if(check){
                System.out.println( number + " is a prime");
            }else {
                System.out.println(number + " is not a prime");
            }
            number++;
        }
    }
}
