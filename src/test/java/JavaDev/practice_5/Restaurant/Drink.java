package JavaDev.practice_5.Restaurant;

public class Drink implements Dish {
    double value;
    String name;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println(getName() + " - с объемом: "+ getValue());
    }
}
