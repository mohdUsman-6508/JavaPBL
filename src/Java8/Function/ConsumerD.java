package Java8.Function;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerD {
    public static void main(String[] args) {
        User u1 = new User("Issac", "1");
        User u2 = new User("Newton", "2");

        ArrayList<User> users = new ArrayList<>();
        Consumer<User> addUser = user -> users.add(user);

        addUser.accept(u1);
        addUser.accept(u2);
        Consumer<ArrayList<User>> consume = name -> System.out.println(name);

        consume.accept(users);
    }
}

class User {
    String name;
    String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ":" + name;
    }
}
