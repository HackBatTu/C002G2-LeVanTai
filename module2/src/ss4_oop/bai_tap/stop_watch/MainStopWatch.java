package ss4_oop.bai_tap.stop_watch;



public class MainStopWatch {

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        for (int i =0 ; i<100000; i++){
            System.out.println("gà");
        }
        long t2 = System.currentTimeMillis();

        System.out.println(" fisrt: "+ t1);
        System.out.println(" later : "+ t2);
        System.out.println("thời gian : " + (t2-t1)+ " miligiay" );
    }
}