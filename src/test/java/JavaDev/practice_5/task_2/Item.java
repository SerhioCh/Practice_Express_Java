package JavaDev.practice_5.task_2;

public class Item implements Printable {
    private String  name;
    private  double price;
    private  int count;

    public  Item (String name , double price, int count){
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        System.out.println("Мой товар: имя "+ this.name + ", цена "+ this.price + ", количество "+ this.count);
    }
}
