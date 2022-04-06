package ss4_oop.bai_tap;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
    }

    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public void start(){
        startTime = LocalTime.now();
    }

    public void end(){
        endTime = LocalTime.now();
    }

    public int getElapsedTime() {
        int milisecond = ((endTime.getHour() - startTime.getHour()) * 3600 +
                (endTime.getMinute() - startTime.getMinute()) * 60 +
                (endTime.getSecond() - startTime.getSecond())) * 1000;
        return milisecond;
    }
}
