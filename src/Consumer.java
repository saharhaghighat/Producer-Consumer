public class Consumer implements Runnable {

    private MyQueue myQueue;

    private volatile boolean isStopped;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
        this.isStopped = false;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume(){
        while (!isStopped){
            while (myQueue.isEmpty()){
                try {
                    myQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (isStopped)
                break;

            Messages messages=myQueue.pull();
            myQueue.notifyOnFull();
            System.out.println("Message:"+messages);
            System.out.println("Consumed On "+ Thread.currentThread().getId()+
                               " Size : "+myQueue.getQueue().size());
        }
        System.out.println("Consumer Stopped!");
    }

    public void stop(){
        isStopped=true;
    }

}
