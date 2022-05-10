package Exam.controllers;
import Exam.utils.Regex;

public class DisplayControllers {


    public void display(){
        while (true){
            System.out.println("**---Menu Manager---***");
            System.out.print(""+
                    " 0. Thoát.\n" +
                    "you choice : ");
            int choice =  Regex.checkParseInt();
            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }
    public void display1(){
        while (true){
            System.out.println("**---Menu Manager---***");
            System.out.print(""+
                    " 0. Thoát.\n" +
                    "you choice : ");
            int choice =  Regex.checkParseInt();
            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }

}
