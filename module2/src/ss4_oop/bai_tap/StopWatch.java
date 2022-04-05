package ss4_oop.bai_tap;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
        startTime = LocalTime.now();
    }

    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStart() {
        return startTime;
    }

    public LocalTime getStop() {
        return endTime;
    }
    public void start(){
        startTime=LocalTime.now();
    }

    public void stop(){
        endTime=LocalTime.now();
    }


    public int getElapsedTime() {
        int miliSecond = ((endTime.getHour() - startTime.getHour()) * 3600 +
                (endTime.getMinute() - startTime.getMinute()) * 60 +
                (endTime.getSecond() - startTime.getSecond())) * 1000;
        return miliSecond;
    }
}
