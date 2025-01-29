package Java17;

public class patternMatchingInstanceof {
    public static void main(String[] args) {
        // Old way with pattern matching (Before Java 17)
        Object obj = "abc";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.length());
        }

        // New way with pattern matching (Since Java 17)
        if (obj instanceof String str) {
            System.out.println(str.length());
        }
    }
}
