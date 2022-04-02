package ss2_loop.bai_tap;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
            int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice!=0){
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2. Draw the triangle botton-left");
            System.out.println("3. Draw the triangle top-left");
            System.out.println("4.Print isosceles triangle");
            System.out.println("5. Exit");
            System.out.println("Enter the choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("1. Draw the rectangle");
                    for (int i=1 ; i<=5 ; i++){
                        for (int j=1 ; j<=5; j++){
                            if(i==1||j==1||i==5||j==5){
                                System.out.print("*");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("\n");
                    }
                    break;
                case 2 :
                    System.out.println("2. Draw the triangle botton-left");
                    for (int i=1 ; i<=5 ; i++){
                        for (int j=1 ; j<=i; j++){
                            if(i==1||j==1||i==5||j==i){
                                System.out.print("*");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3 :
                    System.out.println("3. Draw the triangle top-left");
                    for (int i=1 ; i<=7 ; i--){
                        for (int j=1 ; j<=i; j++){
                            if(i==1||j==1||i==7||j==i){
                                System.out.print("*");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("\n");
                    }
                    break;
                case 4 :
                    for(int i= 1 ; i<=5 ; i++ ){
                        for (int a=5 ; a>=i ; a--){
                            System.out.print("-");
                        }
                        for (int j =1 ; j<=i*2-1 ; j++){
                            if(i==1 || j == 1|| i==5|| j ==i*2-1){
                                System.out.print("$");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("\n");
                    }
                case 5 :
                    choice = 0;
                    break;
                default:
                    System.out.println("No choice");
                    break;

            }
        }
    }
}
