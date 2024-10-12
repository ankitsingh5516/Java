package CoreJava.DateTimeQuestions;

import java.time.LocalDate;

public class CheckCurrentLeapYear {
    public static void main(String[] args) {
        boolean currentYear=LocalDate.now().isLeapYear();
        System.out.println(" current year is leap year- "+currentYear);

    }
}
