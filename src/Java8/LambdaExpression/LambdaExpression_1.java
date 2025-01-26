package Java8.LambdaExpression;
//1//
import java.util.function.IntBinaryOperator;

public class LambdaExpression_1 {

    // Before Java 8
    private int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        //Before Java 8
        LambdaExpression_1 lambda = new LambdaExpression_1();
        int sum = lambda.add(1, 2);
        System.out.println(sum);

        // After Java 8

//        IntBinaryOperator lambdaSum = (int a, int b) -> {
//            return a + b;
//        };

//        IntBinaryOperator lambdaSum = (a, b) -> {
//            return a + b;
//        };

        // minimalistic code
        IntBinaryOperator lambdaSum = (a, b) -> a + b;
        System.out.println(lambdaSum.applyAsInt(1,2));
    }

    // Lambda expression in Java 8
    // minimal code, functional Interface
}
