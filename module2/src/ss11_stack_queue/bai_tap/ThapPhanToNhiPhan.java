package ss11_stack_queue.bai_tap;

import java.util.*;
public class ThapPhanToNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Thap Phan: ");
        int num = Integer.parseInt(sc.nextLine());
        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        System.out.print("Nhi Phan = ");
        while (!(stack.isEmpty() )) {
            System.out.print(stack.pop());
        }
        System.out.println();

    }
}
