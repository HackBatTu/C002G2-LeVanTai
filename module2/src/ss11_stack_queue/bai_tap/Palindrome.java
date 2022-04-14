package ss11_stack_queue.bai_tap;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Enter the String :");
        Scanner sc =new Scanner(System.in);
        String inputString = sc.nextLine();
        Queue queue = new LinkedList();
        for (int i = inputString.length()-1; i >=0; i--) {
            queue.add(inputString.charAt(i));
        }
        String reverseString = "";
        while (!queue.isEmpty()) {
            reverseString = reverseString+queue.remove();
        }
        if (inputString.equals(reverseString))
            System.out.println("this is a Palindrome String");
        else
            System.out.println("this is a not Palindrome String ");
    }
}
