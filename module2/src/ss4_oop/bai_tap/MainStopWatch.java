package ss4_oop.bai_tap;

import java.time.LocalTime;

public class MainStopWatch {

    public static void main(String[] args) {

        StopWatch st = new StopWatch();

        st.setStartTime(LocalTime.now());
        LocalTime start = LocalTime.now();
        System.out.println(start);

        System.out.println("nhập thời gian kết thúc : ");
        LocalTime end = st.getEndTime();
        System.out.println(end);
        System.out.println("Elapsed time: " + st.getElapsedTime());
        st.start();
        st.end();
    }
}