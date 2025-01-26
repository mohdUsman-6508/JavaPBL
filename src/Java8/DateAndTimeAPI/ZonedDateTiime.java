package Java8.DateAndTimeAPI;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

public class ZonedDateTiime {
    public static void main(String[] args) {
        ZonedDateTime indiaTime = ZonedDateTime.now();
        System.out.println(indiaTime);

        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newYorkTime);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);


    }
}
