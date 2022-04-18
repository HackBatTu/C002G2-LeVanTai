package ss11_stack_queue.bai_tap;

import java.util.Stack;

public class Reverse {
    private static Stack<Integer> st = new Stack<>();
    private static Stack<String> tack = new Stack<>();

    static String reverseArray(int[] arr){
        for (int i = 0;i<arr.length;i++){
            st.push(arr[i]);
        }
        String reverse = "";
        while (!st.isEmpty()){
            reverse = reverse + st.pop() + "\t";
        }
        return reverse;

    }
    static  String reverseString(String str){
        for (int i =0 ; i< str.length(); i++){
            tack.push(str.charAt(i) + "");
        }
        String str1 ="";
        while (!tack.isEmpty()){
            str1+=tack.pop();
        }

    return str1;
    }

    static int reverseNumber(int number) {
        while (number != 0) {
            st.push(number % 10);
            number = number / 10;
        }
        int reverse = 0;
        int i = 1;
        while (!st.isEmpty()) {
            reverse = reverse + (st.peek() * i);
            st.pop();
            i=i*10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Reverse reverseInteger = new Reverse();
        System.out.println(reverseInteger.reverseArray(arr));
        System.out.println("----------------");

        String str = "con gà luận";
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverseString(str));
        System.out.println("----------------");
        int number = 1234567;
        System.out.println(reverseNumber(number));

    }
}
