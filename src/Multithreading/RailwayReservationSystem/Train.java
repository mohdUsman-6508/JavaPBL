package Multithreading.RailwayReservationSystem;

public class Train {
    private String trainName;
    private int totalSeats;
    private int availableSeats;

    public Train(String trainName, int totalSeats) {
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTickets(int numOfSeats, String passengerName) {

        try {
            if (numOfSeats <= availableSeats) {
                System.out.println("Please wait...");
                System.out.println(passengerName + " booking is processing...");
                Thread.sleep(2000);
                availableSeats -= numOfSeats;
                System.out.println(passengerName + " successfully booked " + numOfSeats + " seats. Remaining seats: " + availableSeats + ".");
            } else {
                System.out.println("Booking in progress...");
                Thread.sleep(1000);
                System.out.println("booking failed!");
                System.out.println(passengerName + " needs " + numOfSeats + " seats. Available seats: " + availableSeats);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats: " + this.availableSeats);
    }
}
