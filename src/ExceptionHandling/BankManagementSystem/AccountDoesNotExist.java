package ExceptionHandling.BankManagementSystem;

public class AccountDoesNotExist extends RuntimeException {
    public AccountDoesNotExist(String message) {
        super(message);
    }
}
