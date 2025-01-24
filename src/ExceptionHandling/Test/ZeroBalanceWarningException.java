package ExceptionHandling.Test;


//custom Exception

public class ZeroBalanceWarningException extends Exception {

    public ZeroBalanceWarningException() {
        super("Account has Zero Balance");
    }
}
