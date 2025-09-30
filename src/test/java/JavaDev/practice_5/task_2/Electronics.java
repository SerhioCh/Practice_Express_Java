package JavaDev.practice_5.task_2;

public class Electronics extends  Item{
    private  final  static int DEFAULT_GUARANTEE = 2;
    private  int gurantee;

    public Electronics(String name, double price, int count) {
        super(name, price, count);
        this.gurantee = DEFAULT_GUARANTEE;
    }

    public int getGurantee() {
        return gurantee;
    }


    @Override
    public void print() {
        super.print();
        System.out.print(", гарантия "+ this.gurantee+ " года");
    }
}
