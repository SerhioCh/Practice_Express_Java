package JavaDev.practice_12;

public class Task7 {
    private static int balance = 120; // Сделал 120 чтоб выполнялось 2 потока
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> withdraw(60));
        Thread t2 = new Thread(() -> withdraw(50));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public synchronized static void withdraw(int amount) {
        if (balance >= amount) {
            try { Thread.sleep(100); } catch (InterruptedException e) { }
            balance -= amount;
            System.out.println("New balance: " + balance);
        }
    }
}
