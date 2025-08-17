package practice_10.HomeWork;

public class TaskOne implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println("Привет из потока");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TaskOne taskOne = new TaskOne();
        Thread t1 = new Thread(taskOne);
        t1.start(); // Задача 1
        t1.join(); // не обязательно ждем окончание потока
    }
}
