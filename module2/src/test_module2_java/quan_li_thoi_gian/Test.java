package test_module2_java.quan_li_thoi_gian;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        // lấy time hiện tại
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100 ; i++){
            System.out.println("gà");
        }
        long t2 = System.currentTimeMillis();

        System.out.println("trk khi chạy for: "+ t1);
        System.out.println("sau khi chạy for: "+ t2);
        System.out.println("thời gian : "+ (t2-t1)+" mls");
        System.out.println("thời gian : "+ (t2-t1)/1000+" s");

        // timeUnit
        System.out.println("1000 năm = " + TimeUnit.DAYS.toSeconds(1000*365)+"s");
        System.out.println("3 giờ = " + TimeUnit.HOURS.toSeconds(3)+"s");

        //Date
        Date a = new Date(System.currentTimeMillis());
        System.out.println(a.getDate()+"/"+(a.getMonth()+1)+"/"+(a.getYear()+1900));

        //Calendar
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));

        c.add(Calendar.HOUR,30); // cộng thêm giờ vào
        System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
        c.add(Calendar.DATE,14); // cộng thêm ngày
        System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));

        // DateFomat .//giờ ngày hiện tại
        DateFormat df =new SimpleDateFormat();
        System.out.println(df.format(a));
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(a));
    }
}
