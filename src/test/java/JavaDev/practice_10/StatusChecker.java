package JavaDev.practice_10;

public class StatusChecker implements Runnable {

    public  boolean active;

    @Override
    public void run() {
        while (active){
            System.out.println(Thread.currentThread().getName()+" поток бежит");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public  void stop(){
        this.active = false;
    }
}
