package Java17;

public class PatternMatchingSwitch {

    public static void main(String[] args) {
        PaymentProcessing paymentProcessing=new PaymentProcessing();
        printDay(1);
        printDay(4);
        printDay(0);
        Integer a= (Integer) 500;
        paymentProcessing.processPayment(new CreditCardPayment("1234-5678-9876-5432"));
        paymentProcessing.processPayment(new PayPalPayment("user@example.com"));
        paymentProcessing.processPayment(a);
        paymentProcessing.processPayment(null);
    }

    static void printDay(int dayNumber) {
        String day = null;
        switch (dayNumber) {
            case 1 -> day = "Monday";
            case 2 -> day = "Tuesday";
            case 3 -> day = "Wednesday";
            case 4 -> day = "Thursday";
            case 5 -> day = "Friday";
            case 6 -> day = "Saturday";
            case 7 -> day = "Sunday";
            default -> System.out.println("Invalid input");
        }
        if (day != null) System.out.println(day);
    }


}

//Record class for CreditCardPayment
record CreditCardPayment(String cardNumber) {}

//Record class for PayPalPayment
record PayPalPayment(String email) {}

 class PaymentProcessing {

  static void processPayment(Object payment) {
        String result = switch (payment) {
            case CreditCardPayment cc ->
                    "Processing Credit Card payment with card number: " + cc.cardNumber();
            case PayPalPayment pp -> "Processing PayPal payment with email: " + pp.email();
            case Integer amount -> "Processing Cash payment of $" + amount;
            case null -> "Invalid payment method: null";
            default -> "Unknown payment method.";
        };
        System.out.println(result);
    }
}
