package ss13_search.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        // Tìm chuỗi tăng dần có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) { //Vòng lặp bên ngoài
            //Khai báo một linked list trung gian các kí tự của chuỗi tăng dần
            LinkedList<Character> list = new LinkedList<>();
            //thêm kí tự thứ i vào trong list
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) { //vòng lặp bên trong
                //Kiểm tra kí tự tiếp theo có lớn hơn kí tự cuối cùng trong list hay không
                if (string.charAt(j) > list.getLast()) {
                    //Nếu có thì thêm vào trong list
                    list.add(string.charAt(j));
                }
            }
            //So sánh kích cỡ của list trung gian và list chứa chuỗi tăng dần có kích thước lớn nhất
            if (list.size() > max.size()) {
                //Nếu kích cỡ của list trung gian lớn hơn kích cỡ của list có độ dài lớn nhất thì gán lại max
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        // Hiển thị chuỗi tăng dần dài nhất
        for (Character ch: max) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
        System.out.println();
    }
}
