package Java8.Function;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperator {
    public static void main(String[] args) {

        Predicate<Character> isA = (character) -> character == 'A' || character == 'a';

        UnaryOperator<String> removeA = (name) -> {
            StringBuilder modifiedStr = new StringBuilder();
            for (char c : name.toCharArray()) {
                if (isA.negate().test(c)) {
                    modifiedStr.append(c);
                }
            }
            return modifiedStr.toString();
        };

        System.out.println(removeA.apply("Apple Orange"));

        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2,4));

    }
}
