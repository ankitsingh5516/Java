package CoreJava.DateTimeQuestions;

import java.time.LocalDate;
import java.time.Period;

public class CalculateAge {
    public static void main(String[] args) {
        LocalDate birthdate = LocalDate.of(2002, 9, 28);

        LocalDate currentDate = LocalDate.now();
        Period period=Period.between(birthdate,currentDate);
        System.out.println("day- "+period.getDays()+" months- "+period.getMonths()+" years- "+period.getYears());

    }

}
