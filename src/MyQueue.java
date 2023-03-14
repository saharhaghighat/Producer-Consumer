import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {


    private final Queue<Messages> queue;

    public Queue<Messages> getQueue() {
        return queue;
    }

    private final int Capacity;
    private final Object Full_Queue;
    private final Object Empty_Queue;

    public MyQueue(int capacity) {
        this.queue = new LinkedList<>();
        Capacity = capacity;
        Full_Queue = new Object();
        Empty_Queue = new Object();
    }

    public boolean isFull() {
        return this.queue.size() == Capacity;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void waitOnFull() throws InterruptedException {
        synchronized (Full_Queue) {
            Full_Queue.wait();
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (Empty_Queue) {
            Empty_Queue.wait();
        }
    }

    public void notifyOnEmpty() {
        synchronized (Empty_Queue) {
            Empty_Queue.notify();
        }
    }

    public void notifyOnFull() {
        synchronized (Full_Queue) {
            Full_Queue.notify();
        }
    }


    public void put(Messages Message) {
        synchronized (queue) {
            queue.add(Message);
        }
    }

    public Messages pull() {
        synchronized (queue) {
            return queue.poll();
        }
    }

}
