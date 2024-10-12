package CoreJava.DateTimeQuestions;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ChangeLocalDateObject {
    public static void main(String[] args) {

        String date="10-07-2024";
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.valueOf(date));
        System.out.println(dateTimeFormatter);

    }
}
