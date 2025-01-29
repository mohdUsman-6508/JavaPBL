package Java17;

public class SealedClasses {
}


sealed class Shape1
        // The permits clause has been omitted
        // as its permitted classes have been
        // defined in the same file.
{ }

final class Circle1 extends Shape1{
    float radius;
}

non-sealed class Square extends Shape1{
    float side;
}

sealed class Rectangle extends Shape1{
    float length, width;
}

final class FilledRectangle extends Rectangle {
    int red, green, blue;
}

//
// sealed class Account permits SavingsAccount, FixedDepositAccount { }
// final class SavingsAccount extends Account { }    // Allowed
// final class FixedDepositAccount extends Account { }   // Allowed
// final class CheckingAccount extends Account { }   // Not Allowed