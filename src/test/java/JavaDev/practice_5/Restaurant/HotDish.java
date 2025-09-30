package JavaDev.practice_5.Restaurant;

public class HotDish implements Dish {
    int temperature;
    String name;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println(getName() + " - с температурой: " + getTemperature());
    }
}
