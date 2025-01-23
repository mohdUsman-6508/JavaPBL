public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] arr = {30, 28, 10, 41, 10, 25, 81, 47, 90};

        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                secondMax = max;
                max = arr[i];
            }
            if (max > arr[i] && secondMax < arr[i]) {
                secondMax = arr[i];
            }
        }

        System.out.println("Max:" + max + ", Second Max:" + secondMax);
    }
}