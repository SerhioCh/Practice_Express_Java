package practice_10.HomeWork;

public class TaskFour {
    private int count ;

    public  synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        TaskFour task = new TaskFour();
        Thread t1 = new Thread(()->{
            for (int i=0;i<1000;i++){
                task.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0;i<1000;i++){
                task.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count: "+ task.count);
    }
}
