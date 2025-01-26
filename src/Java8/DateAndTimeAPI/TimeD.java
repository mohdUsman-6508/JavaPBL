package Java8.DateAndTimeAPI;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeD {
    public static void main(String[] args) {

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime customTime = LocalTime.of(15, 52, 00, 00);
        LocalTime parsedTime = LocalTime.parse("10:11:12");
        LocalTime beforeOneHour = now.minusHours(1);

        System.out.println(beforeOneHour);
        System.out.println(customTime);
    }
}
