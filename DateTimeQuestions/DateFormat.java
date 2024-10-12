package CoreJava.DateTimeQuestions;
import java.util.Date;
import java.text.SimpleDateFormat;


public class DateFormat {
    public static void main(String[] args) {
        Date currentDate = new Date();

        SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
        String pattern=date.format(currentDate);
        System.out.println("Current Date- "+pattern);

    }
}
