public class Producer implements Runnable {
private  MyQueue myQueue;
private volatile boolean isStopped;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
        this.isStopped=false;
    }


    @Override
    public void run() {

    }
    public void produce(String phoneNumber, String message){
        int sequence=0;
        while (!isStopped){
            while (myQueue.isFull()){
                try {
                    myQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (isStopped)
                break;


            myQueue.put(new Messages(phoneNumber,message+sequence++));
            myQueue.notifyOnEmpty();
            System.out.println("produced on "+Thread.currentThread().getId()+
                    "size  :"+myQueue.getQueue().size());
        }
        System.out.println("producer is stopped");
    }
    public void stop(){
        isStopped=true;
    }
}
