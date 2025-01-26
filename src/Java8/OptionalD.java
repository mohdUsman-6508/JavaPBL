package Java8;

import java.util.Optional;

public class OptionalD {
    public static void main(String[] args) {
//        String name = getName(1);
//        System.out.println(name.toLowerCase()); // NullPointerException

        Optional<String> name = getName(1);
//        if (name.isPresent()) {
//            System.out.println(name.get());
//        }
        name.ifPresent(System.out::println);

        String nameToBeUsed = name.orElse("NA");
        System.out.println(nameToBeUsed);

    }

    private static Optional<String> getName(int id) {
//        String name = "hello";
//        return Optional.of(name);

        String name = null;

        return Optional.ofNullable(name);
//        return Optional.empty();
    }
}
