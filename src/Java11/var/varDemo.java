package Java11.var;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class varDemo {
    public static void main(String[] args) {
        // Benefit
//        (@Nonnull var s1, @Nullable var s2) -> s1 + s2;

        BinaryOperator<Integer> sum = (var s1, var s2) -> s1 + s2;
        System.out.println(sum.apply(1, 2));

        int a = 10;
        String b = "10";
        var c = (a + b);
        System.out.println(c);

        // limitations
//        (var s1, s2) -> s1 + s2;
//        (var s1, String s2) -> s1 + s2;
//        s1 -> s1.toUpperCase();
    }


}
