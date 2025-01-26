package Java8.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierD {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        Supplier<List<User>> getUsers = () -> {
            User u1 = new User("Faraday", "4");
            User u2 = new User("Micheal", "5");
            users.add(u1);
            users.add(u2);
            return users;
        };

        List<User> users1 = getUsers.get();
        Consumer<List<User>> showUsers = (list) -> System.out.println(list);
        showUsers.accept(users1);

    }
}

