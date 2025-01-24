package Multithreading.RailwayReservationSystem;

public class ReservationSystem {

    public static void main(String[] args) {

        // here we are simulating that multiple users are trying to book tickets at the same time
        // user --> thread

        Train train = new Train("Netaji Express", 10);

        //user1 is booking
        Thread user1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                train.bookTickets(2, "User1");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        );

        ///  ////////////////////////////////////////////////////////////////////////////////////////

        //User2 is booking
        Thread user2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                train.bookTickets(5, "User2");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });


        /// ////////////////////////////////////////////////////////////////////////////////////

        // User3 is booking
        Thread user3 = new Thread(() -> {
            try {
                Thread.sleep(500);
                train.bookTickets(4, "User3");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });


        user1.start();
        user2.start();
        user3.start();


    }

}
