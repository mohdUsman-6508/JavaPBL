package Java8.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionD {
    public static void main(String[] args) {

        Function<String, Integer> len = x -> x.length();

        Predicate<Integer> isPositive = x -> x > 0;

        List<Integer> list = Arrays.asList(1, 2, 3, -2, -3, -4, 5, 7, 8);

        Function<List<Integer>, Integer> countPositive = list1 -> {
            int count = 0;
            for (int val : list1) {
                if (isPositive.test(val)) {
                    count++;
                }
            }
            return count;
        };


        System.out.println(countPositive.apply(list));

        Function<Integer, Integer> makeDouble = x -> 2 * x;
        Function<Integer, Integer> doSquare = x -> x * x;

        System.out.println(makeDouble.andThen(doSquare).apply(3));
        System.out.println(doSquare.andThen(makeDouble).apply(4));


    }
}
