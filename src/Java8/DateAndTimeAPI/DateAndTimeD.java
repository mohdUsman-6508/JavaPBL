package Java8.DateAndTimeAPI;

import java.time.LocalDateTime;

public class DateAndTimeD {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime myDateTime = LocalDateTime.parse("2025-01-11T18:50");
        System.out.println(now);
    }

}
