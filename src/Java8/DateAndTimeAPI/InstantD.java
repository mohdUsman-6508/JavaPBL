package Java8.DateAndTimeAPI;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantD {
    public static void main(String[] args) {
        //1972 till now millisec ?
        long l = System.currentTimeMillis();
        System.out.println(l);

        Instant now = Instant.now();
        System.out.println(now);

        // //////////////////////

        Instant start = Instant.now();
        for (int i = 0; i < 1000000; i++) {

        }
        Instant end = Instant.now();

        Duration d1 = Duration.between(start, end);
        Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(d1);
        System.out.println(d2);
    }
}
