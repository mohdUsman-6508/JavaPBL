package Java8.Function;

import java.util.Iterator;
import java.util.function.Predicate;

// test, and, or , negate

public class PredicateD {
    public static void main(String[] args) {

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;

        Predicate<Integer> isPositiveAndEven = isEven.and(isPositive);
        Predicate<Integer> isOdd = isEven.negate();
        Predicate<String> isNewton = name -> name.equalsIgnoreCase("Newton");

        System.out.println(isNewton.test("Newton"));

        int[] nums = {2, 4, 3, 5, -2, -6, 1, 8, -9};

        for (int val : nums) {
            if (isPositiveAndEven.test(val)) {
                System.out.println(val + " ");
            }
            if (isOdd.test(val)) System.out.println("odd:" + val);
        }


    }


}
