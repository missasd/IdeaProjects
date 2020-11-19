package java7ConcurrentProgram.chp2.p4;

public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread threadProducer = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread threadConsumer = new Thread(consumer);

        threadConsumer.start();
        threadProducer.start();


    }
}
