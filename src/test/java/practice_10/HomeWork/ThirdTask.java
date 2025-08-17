package practice_10.HomeWork;

public class ThirdTask implements Runnable {

    public volatile  boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Поток: "+ Thread.currentThread().getName());
        }
    }

    public void setStop(){
      this.stop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        ThirdTask thirdTask = new ThirdTask();

        Thread t1 = new Thread(thirdTask);
        Thread t2 = new Thread(thirdTask::setStop);
        t1.start();
        Thread.sleep(2000);
        t2.start();
        t1.join();
        t2.join();
    }



}
