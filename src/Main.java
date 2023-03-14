public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);

        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread proThread = new Thread(producer);
        Thread conThread = new Thread(consumer);

        proThread.start();
        conThread.start();


        MyMethod.sleep(1000);
        producer.stop();
        consumer.stop();


    }
}