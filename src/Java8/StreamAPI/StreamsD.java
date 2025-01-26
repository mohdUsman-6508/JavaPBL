package Java8.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsD {
    public static void main(String[] args) {

        // creating streams

        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        Stream<String> stream1 = list.stream();

        String[] arr = {"apple", "banana", "kiwi"};
        Stream<String> stream2 = Arrays.stream(arr);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        Stream<Integer> integerStream1 = Stream.iterate(1, n -> n + 1).limit(100);

        Stream<String> stringStream = Stream.generate(() -> "helloWorld").limit(3);
        System.out.println(stringStream.toList());


    }
}
