package Multithreading.ConsumerProducer;

public class ConsumerProducer {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread consumerThread = new Thread(new Consumer(resource));

        // this is Java 8 way ( easier)
        // Function Interface

        Thread producerTherad = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.produce(i);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        consumerThread.start();
        producerTherad.start();
    }
}


//shared resource
//could have use BlockingDeque
class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
                System.out.println(e.getMessage());
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        Thread.sleep(500);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
                System.out.println(e.getMessage());
            }
        }
        hasData = false;
        System.out.println("Consumed:" + data);
        Thread.sleep(500);
        notify();
        return data;
    }

}


// this is old way
class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

