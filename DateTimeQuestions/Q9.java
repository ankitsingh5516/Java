package CoreJava.DateTimeQuestions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Q9 {
    public static void main(String[] args) throws Exception {

        String time1 = "18:00";
        String time2 = "7:30";
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("HH:mm");

        Date date1 = simpleDateFormat.parse(time1);
        Date date2 = simpleDateFormat.parse(time2);

        long DiffInTime = Math.abs(date2.getTime() - date1.getTime());


        long differenceInHours = (DiffInTime / (60 * 60 * 1000)) % 24;

        long differenceInMinutes = (DiffInTime / (60 * 1000)) % 60;


        System.out.println("Difference is " + differenceInHours + " hours " + differenceInMinutes + " minutes ");
    }
}
