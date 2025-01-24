package ExceptionHandling.BankManagementSystem;

import java.util.HashMap;

public class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    private static HashMap<String, BankAccount> accountList = new HashMap<>();

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0;
    }

    public void createBankAccount(String accountNumber, BankAccount account) {
        if (accountList.containsKey(accountNumber)) {
            System.out.println("Account already exist");
            return;
        }
        accountList.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }

    public static double deposit(double amount, String accountNumber) {

        isAccountExist(accountNumber);
        BankAccount currAccount = accountList.get(accountNumber);

        if (amount > 0) {
            currAccount.balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("Account Number: " + accountNumber + " Current Balance: ₹ " + currAccount.balance);
            return currAccount.balance;
        } else {
            throw new NegativeAmountException("Amount cannot be negative in value!");
        }
    }

    public static double withdraw(double amount, String accountNumber) {
        isAccountExist(accountNumber);
        BankAccount currAccount = accountList.get(accountNumber);

        if (amount > currAccount.balance) {
            throw new InsufficientFundsException("Insufficient balance!" + " Available balance: ₹ " + currAccount.balance);
        }

        if (amount > 0) {
            currAccount.balance -= amount;
            System.out.println("Amount withdrew successfully.");
            System.out.println("Account Number: " + accountNumber + " Available Balance: ₹ " + currAccount.balance);
            return currAccount.balance;
        } else {
            throw new NegativeAmountException("Amount cannot be negative in value!");
        }

    }

    public static void isAccountExist(String accountNumber) {
        if (!accountList.containsKey(accountNumber)) {
            throw new AccountDoesNotExist("Account does not exist, please check account number!");
        }
    }

    public static boolean transfer(double amount, String sourceAccountNumber, String destinationAccountNumber) {
        isAccountExist(sourceAccountNumber);
        isAccountExist(destinationAccountNumber);

        BankAccount sourceAccount = accountList.get(sourceAccountNumber);
        BankAccount destinationAccount = accountList.get(destinationAccountNumber);

        if (sourceAccount.balance < amount) {
            throw new InsufficientFundsException("Insufficient balance!" + " Available balance: ₹" + sourceAccount.balance);
        }

        if (amount > 0) {
            sourceAccount.balance -= amount;
            destinationAccount.balance += amount;

            System.out.println("₹ " + amount + " transferred to " + destinationAccount.accountNumber + " Current balance ₹ " + destinationAccount.balance);
            System.out.println("₹ " + amount + " transferred from " + sourceAccount.accountNumber + " Available balance ₹" + sourceAccount.balance);
            return true;
        } else {
            throw new NegativeAmountException("Amount cannot be negative in value!");
        }
    }

    public static void checkAccountDetails(String accountNumber) {
        isAccountExist(accountNumber);
        BankAccount account = accountList.get(accountNumber);
        double currentBalance = accountList.get(accountNumber).balance;
        System.out.printf(" Account Number: %s %n Account Holder: %s %n Available Balance: ₹ %f %n ", accountNumber, account.accountHolderName, account.balance);
    }

}
