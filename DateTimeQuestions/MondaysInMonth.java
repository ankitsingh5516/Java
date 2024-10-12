package CoreJava.DateTimeQuestions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class MondaysInMonth {

    public static void main(String[] args) {
        int year = 2024;
        int month = 10;

        List<LocalDate> mondays = getMondays(year, month);

        System.out.println("Mondays in " + YearMonth.of(year, month));
        mondays.forEach(System.out::println);

    }

    public static List<LocalDate> getMondays(int year, int month) {
        List<LocalDate> mondays = new ArrayList<>();

        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = YearMonth.of(year, month).atEndOfMonth();

        while (!date.isAfter(lastDayOfMonth)) {
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondays.add(date);
            }
            date = date.plusDays(1);
        }

        return mondays;
    }
}
