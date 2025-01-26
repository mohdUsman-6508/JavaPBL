package Java8.DateAndTimeAPI;

import java.time.LocalDate;

public class DateD {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate independece = LocalDate.of(1947, 8, 15);
        System.out.println(independece.getDayOfMonth());

        LocalDate yesterday = today.minusDays(1);
        System.out.println(yesterday);

    }
}