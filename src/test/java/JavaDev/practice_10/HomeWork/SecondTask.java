package JavaDev.practice_10.HomeWork;

public class SecondTask implements Runnable {
    private final int iterations;
    private  final  String message;

    SecondTask(int iterations , String message){
        this.iterations = iterations;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i =0; i<iterations;i++){
            System.out.println(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SecondTask(5,"A"));
        Thread t2 = new Thread(new SecondTask(5,"B"));
        t1.start();  //Задача 2
        t1.join();
        t2.start();  //Задача 2
        t2.join();
    }
}
