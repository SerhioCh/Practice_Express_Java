package JavaDev.practice_10;

public class Counter {
    // методы по увеличению  и уменьшению значений

    private int count = 0;

    public  synchronized void increment(){
        this.count++;
    }
    public synchronized   void decrement(){
        this.count--;
    }

    public  synchronized int getCount(){
        return this.count;
    }
}
