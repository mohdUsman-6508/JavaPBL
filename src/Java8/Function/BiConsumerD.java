package Java8.Function;

import java.util.function.BiConsumer;

public class BiConsumerD {
    public static void main(String[] args) {
        BiConsumer<String, Double> employee = (designation, salary) -> System.out.println(designation + ":" + salary);
        employee.accept("Architecture", 100.50);
    }
}
