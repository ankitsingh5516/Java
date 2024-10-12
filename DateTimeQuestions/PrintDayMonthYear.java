package CoreJava.DateTimeQuestions;

import java.time.LocalDate;
import java.time.Month;

public class PrintDayMonthYear {
    public static void main(String[] args) {
        int day= LocalDate.now().getDayOfMonth();
        Month month=LocalDate.now().getMonth();
        int year=LocalDate.now().getYear();
        System.out.println("day- "+day+", month- "+month+", year- "+year);
    }
}
