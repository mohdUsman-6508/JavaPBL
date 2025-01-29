package Java17;

public class SwitchD {
    public static void main(String[] args) {
        int value = 5;
        switch (value) {
            case 1 -> System.out.println("One");
            case 2 -> System.out.println("Two");
            case 3, 4 -> System.out.println("Three or Four");
            default -> System.out.println("Invalid value");
        }
    }
}
