package ExceptionHandling.Test;

public class BankAccount extends Exception {
    public String accountNumber;
    public static double accountBalance;


    public BankAccount(String accountNumber, double accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public void checkLength() throws Exception {
        if (this.accountNumber.length() != 10) {
            throw new Exception("Account Number must be of 10 digits.");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (accountBalance - amount < 0) {
            throw new ZeroBalanceWarningException();
//            throw new Exception("Not Enough Money");
        } else {
            accountBalance -= amount;
        }
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit atleast 1 rupee");
        } else {
            accountBalance += amount;
        }
    }


}
