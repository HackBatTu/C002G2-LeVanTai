package ss11_stack_queue.bai_tap;

import java.util.*;

public class CountChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str = sc.nextLine();
        str = str.toLowerCase();

        Map<Character, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!treeMap.containsKey(str.charAt(i))) {
                treeMap.put(str.charAt(i), 1);
            } else {
                treeMap.put(str.charAt(i), (treeMap.get(str.charAt(i))+1));
            }
        }

        for (Map.Entry<Character,Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
