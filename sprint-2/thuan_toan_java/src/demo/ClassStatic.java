package demo;

public class ClassStatic {
    private String subject;

    ClassStatic (String subject) {
        this.subject = subject;
    }

    // nested static class
    static class MyWebsite {
        public static String WEBSITE = "codeGym.com";
    }

    public void print() {
        System.out.println("Subject = " + subject);
        System.out.println("Website = " + MyWebsite.WEBSITE);
    }

    public static void main(String[] args) {
        ClassStatic ex1 = new ClassStatic("Core Java");
        ex1.print();
    }
}
