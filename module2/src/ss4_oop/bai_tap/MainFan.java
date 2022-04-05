package ss4_oop.bai_tap;

public class MainFan {
    public static void main(String[] args) {

        Fan fan1 =new Fan(3,10,"Yellow",true);
        Fan fan2 =new Fan(2,5,"blue",false);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
