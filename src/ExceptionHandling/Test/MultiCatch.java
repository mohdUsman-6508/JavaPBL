package ExceptionHandling.Test;

public class MultiCatch {
    public static void main(String[] args) {
        int[] nums = {28, 16, 40, 12, 33, 97};
        int[] divider = {1, 2, 0, 12, 3, 4};

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = divider[i];
            System.out.println(divide(num1, num2));
        }

    }

    public static int divide(int num1, int num2) {
        try {
            int result = num1 / num2;
            return result;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

}
