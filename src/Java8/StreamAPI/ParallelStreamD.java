package Java8.StreamAPI;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamD {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, n -> n + 1).limit(10000).toList();

        //sequential stream
        Instant i1 = Instant.now();
        list.stream().forEach(num -> {
            fact(num);
        });
        Instant i2 = Instant.now();
        Duration d1 = Duration.between(i1, i2);

        //parallel stream
        Instant j1 = Instant.now();
        list.parallelStream().forEach(num -> {
            fact(num);
        });
        Instant j2 = Instant.now();
        Duration d2 = Duration.between(j1, j2);

        System.out.println("Sequential stream time: " + d1.toMillisPart() + " ms");
        System.out.println("Parallel stream time: " + d2.toMillisPart() + " ms");

    }


    static long fact(int num) {
        if (num == 0 || num == 1) return 1;
        return num * fact(num - 1);
    }
}
