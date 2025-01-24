package ExceptionHandling.Test;

public class Test {
    public static void main(String[] args) throws Exception {
        BankAccount b = new BankAccount("321123321", 100);

        try {
            b.withdraw(10);
            b.withdraw(90);
            b.withdraw(10);

        } catch (ZeroBalanceWarningException e) {
            System.out.println(e);
        }

    }
}
