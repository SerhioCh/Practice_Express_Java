package practice_5.Farm;

public class Chicken implements  FarmAnimal{
    @Override
    public void care() {
        System.out.println("Курице требуется кормушка");
    }

    @Override
    public void produce() {
        System.out.println("Курица несет яйца");
    }

    @Override
    public void feed() {
        System.out.println("Курица ест зерно");
    }
}
