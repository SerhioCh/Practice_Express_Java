package JavaDev.practice_10;

public class MainCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter safeCounter = new Counter();

        Thread t1 = new Thread(()->{
            for (int i =0; i<1000;i++){
                safeCounter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i =0; i<1000;i++){
                safeCounter.decrement();
            }
        });
        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("Значение каунт: "+ safeCounter.getCount());
    }
}
