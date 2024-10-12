package CoreJava.DateTimeQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DDMMyyyyHHmmss {
    public static void main(String[] args) throws ParseException {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SS");
            String strDate = sdf.format(calendar.getTime());
            System.out.println("Current date in String Format: "+strDate);

    }
}
