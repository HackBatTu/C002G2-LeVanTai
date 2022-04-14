package ss11_stack_queue.bai_tap;

import java.util.Stack;

public class ReverseInteger {
    static Stack<Integer> st = new Stack<>();
    static void pushInteger(int number) {
        while (number != 0) {
            st.push(number % 10);
            number = number / 10;

        }
    }
    static int reverseNumber(int number) {
        pushInteger(number);
        int reverse = 0;
        int i = 1;
        while (!st.isEmpty()) {
            reverse = reverse + (st.peek() * i);
            st.pop();
            i = i * 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        int number = 234567;
        System.out.println(reverseNumber(number));

    }
}
