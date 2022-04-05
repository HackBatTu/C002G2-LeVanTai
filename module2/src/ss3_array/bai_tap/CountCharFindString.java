package ss3_array.bai_tap;

import java.util.Scanner;

public class CountCharFindString {
    public static void main(String[] args) {
        String str = "Handsome Tai";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the char Find in String : ");
        char main = sc.nextLine().charAt(0);

        int count=0;

        for(int i=0; i< str.length(); i++){
            if(main == str.charAt(i)){
                count++;
            }
        }
        System.out.print("Count char has in string: "+ count);
    }
}
