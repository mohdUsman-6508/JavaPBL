package Java8.LambdaExpression;

// create thread
// Runnable is a funtional interface having exactly one abstract method SPA


public class LambdaExpression_3 {
    public static void main(String[] args) {

        //inner class anonymous-> use when interface have more than 1 abstract methods
        // want to implement interface instantly

        Runnable anonymousInnerClass = new Runnable() {
            int i = 1;

            // i is instance variable
            public void run() {
                int j = 2; // j is local variable
                System.out.println("Hello!" + this.i);
            }
        };

        //lambda expression
        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("line no " + i);
            }
        };
        Thread t1 = new Thread(runnable);


        // more minimalistic
        int j = 2;
        Thread t2 = new Thread(
                () -> {
//                    j = 3; // variable used in le should be final or effectively final

                    for (int i = 1; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
        );

        t1.start();
        t2.start();

    }
}
