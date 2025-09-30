package JavaDev.practice_10;

public class MainValotile {
    public static void main(String[] args) throws InterruptedException {
        StatusChecker statusChecker = new StatusChecker();
        Thread t1 = new Thread(statusChecker);
        t1.start();
        Thread.sleep(500);
        statusChecker.stop();
        Thread t2 = new Thread(statusChecker::stop);
        t2.start();

        t1.join();
        t2.join();
    }
}
