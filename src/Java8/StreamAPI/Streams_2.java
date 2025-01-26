package Java8.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams_2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -2, 3, 4, 5, -5, 6, 6, -6, 7, 8, 9, 4);
        List<Integer> modifiedList = list.stream()
                .filter(x -> x > 0 && x % 2 == 0)
                .map(x -> x * x)
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(4)
                .skip(1)
                .collect(Collectors.toList());

        System.out.println(modifiedList);

        Optional<Integer> i = list.stream()
                .reduce((x, y) -> x + y)
                .map(x -> x / 10);

        System.out.println(i.get());

    }
}

