package Java8.DateAndTimeAPI;

import java.time.LocalDate;
import java.time.Period;

public class PeriodD {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate then = LocalDate.parse("1947-08-15");
        Period period = Period.between(now, then);
        System.out.println(period);
    }
}
