public class MyMethod {
    public static void sleep (int interval){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
