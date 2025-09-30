package JavaDev.practice_5.Farm;

public class Cow implements FarmAnimal  {
    @Override
    public void produce() {
        System.out.println("Корова несет молоко");
    }

    @Override
    public void care() {
        System.out.println("Корове требуется выпас на лугах");
    }

    @Override
    public void feed() {
        System.out.println("Корова ест траву");
    }
}
