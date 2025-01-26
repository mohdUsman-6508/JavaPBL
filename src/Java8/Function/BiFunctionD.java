package Java8.Function;

import java.util.function.BiFunction;

public class BiFunctionD {
    public static void main(String[] args) {
        BiFunction<Float, Float, Float> calBMI = (height, weight) -> (weight) / (height * height);
        System.out.println(calBMI.apply(1.8f, 60f));
    }
}
