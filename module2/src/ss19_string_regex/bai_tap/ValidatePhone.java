package ss19_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String RELAX_PHONE = "^\\([0-9]{2}\\)-\\(0+[0-9]{9}\\)$";
//    private static final String RELAX_PHONE = "^\\(\d{2}\\)-\\(0+\d{9}\\)$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile(RELAX_PHONE);
        while (true) {
            System.out.print("Enter the phone number: ");
            String phone = sc.nextLine();

            if(pattern.matcher(phone).find()){
                System.out.println("True");
                break;
            }else {
                System.out.println("False");
            }

        }
    }
}
