package ss14_sort.thuc_hanh;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random()*99);
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(list);
    }
    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            /* Array may be sorted and next pass not needed */
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
//            [boolean neednextpass = true; cho (int k = 1; k <list.length && neednextpass; k ++) {neednextpass = false; cho (int i = 0; i <list.length - k; i ++) {if (danh sách [i]> danh sách [i + 1]) {/ * danh sách trao đổi [i] với danh sách [i + 1] * / hệ thống .out.println ("trao đổi" + danh sách [i] + "với" + danh sách [i + 1]); int temp = list [i]; danh sách [i] = danh sách [i + 1]; danh sách [i + 1] = temp; neednextpass = true; / * Pass tiếp theo vẫn cần * /}} / * mảng có thể được sắp xếp và vượt qua tiếp theo không cần * / if (neednextpass == false) {system.out.println ("Mảng có thể được sắp xếp và vượt qua tiếp theo"); phá vỡ; Không] x
                /* Show the list after sort */
                System.out.print("List after the  " + k + "' sort: ");
                for (int j = 0; j < list.length; j++) {
                    System.out.print(list[j] + "\t");
                }
                System.out.println();
            }
            }
}
