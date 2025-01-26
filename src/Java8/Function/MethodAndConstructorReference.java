package Java8.Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodAndConstructorReference {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Apple", "Mango", "Grape");
        list.forEach(Print::print);


        Supplier<Print> supplyPrint = Print::new;
        Print p = supplyPrint.get();

    }
}

class Print {

    static void print(String str) {
        System.out.println(str);
    }
}