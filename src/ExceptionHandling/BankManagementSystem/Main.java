package ExceptionHandling.BankManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Open an account to proceed");

        while (true) {
            System.out.println("""
                    1. Create New Account
                    2. Deposit Money
                    3. Withdraw Money
                    4. Transfer Money
                    5. Check Account Details
                    6. Exit
                    """);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter account number");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter account holder name");
                    String accountHolderName = sc.nextLine();

                    BankAccount account = new BankAccount(accountNumber, accountHolderName);
                    account.createBankAccount(accountNumber, account);
                }
                case 2 -> {
                    System.out.println("Enter account number");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter amount");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    BankAccount.deposit(amount, accountNumber);
                }
                case 3 -> {
                    System.out.println("Enter account number");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter amount");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    BankAccount.withdraw(amount, accountNumber);
                }

                case 4 -> {
                    System.out.println("Enter source account number");
                    String sourceAccountNumber = sc.nextLine();
                    System.out.println("Enter destination account number");
                    String destinationAccountNumber = sc.nextLine();
                    System.out.println("Enter amount");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    BankAccount.transfer(amount, sourceAccountNumber, destinationAccountNumber);
                }
                case 5 -> {
                    System.out.println("Enter account number");
                    String accountNumber = sc.nextLine();
                    BankAccount.checkAccountDetails(accountNumber);
                }
                case 6 -> {
                }
                default -> System.out.println("Invalid Input");
            }
            if (choice == 6) {
                break;
            }
        }
    }
}
