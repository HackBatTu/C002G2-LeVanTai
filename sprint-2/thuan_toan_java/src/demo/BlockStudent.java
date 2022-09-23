package demo;

public class BlockStudent {
    private static String subject;
    static {
        System.out.println("Khối static: hello !");
    }
//    static {
//        subject = "Khối static (static blocks)";
//    }
//    BlockStudent () {
//        System.out.println("hàm main() được gọi");
//        System.out.println("Subject = " + subject);
//    }
    public static void main(String args[]) {
        System.out.println("Main: hello !");
//        BlockStudent bs = new BlockStudent();
    }
}
