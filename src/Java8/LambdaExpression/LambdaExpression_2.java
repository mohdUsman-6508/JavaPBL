package Java8.LambdaExpression;

//2// Functional interface
// default, static method

@FunctionalInterface
interface MyInterface {
    void sayHello();

    default void sayBye() {
        System.out.println("Bye!");
    }

    static void sayGoodBye() {
        System.out.println("Good Bye!");
    }
}

// NOTES:(for review)
// old way was first make a class which implements the interface then create an instance of it, to use it
// default and static method in functional interface both have definitions
// default method can be called from its object but static method can only be called by its interface
// implementing class does not know about the static method in interface i.e. they are hidden from implementing class
// functional interface can hold reference of a lambda expression

public class LambdaExpression_2 {

    public static void main(String[] args) {

        MyInterface morning = () -> System.out.println("Good Morning");
        MyInterface afternoon = () -> System.out.println("Good Afternoon");

        morning.sayHello();
        afternoon.sayHello();
        morning.sayBye();
//        morning.sayGoodBye() // compilation error
        MyInterface.sayGoodBye();
    }
}
