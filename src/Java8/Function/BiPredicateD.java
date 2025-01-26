package Java8.Function;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class BiPredicateD {
    public static void main(String[] args) {

        User u1 = new User("David", "i1");
        Supplier<String> nameSupplier = () -> u1.name;
        Supplier<String> idSupplier = () -> u1.id;

        BiPredicate<String, String> isValidUser = (name, id) -> name.equals(nameSupplier.get()) && id.equals(idSupplier.get());
        System.out.println(isValidUser.test("David", "i1"));

    }
}
