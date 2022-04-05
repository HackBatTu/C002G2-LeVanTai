package ss4_oop.bai_tap;

import java.time.LocalTime;

public class MainStopWatch {

    public static void main(String[] args) {
        int []a= new int [100000];
        for (int i = 0; i < 100000; i++) {
            a[i]=(int)(Math.random()*1000);
        }
        LocalTime start = LocalTime.now();
        a =selectionSort(a);
        LocalTime end = LocalTime.now();
        StopWatch s = new StopWatch(start, end);
        System.out.println("Time: "+s.getElapsedTime());
        for(int x : a){
            System.out.println(x);
        }
    }
    public static int[] selectionSort(int...a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    int tempt = a[i];
                    a[i]=a[j];
                    a[j]=tempt;
                }
            }
        }
        return a;
    }

}
