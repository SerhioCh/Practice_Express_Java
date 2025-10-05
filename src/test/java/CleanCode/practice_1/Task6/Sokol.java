package CleanCode.practice_1.Task6;

public class Sokol extends Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("Сокол летает");
    }

    @Override
    public void eat() {
        System.out.println("Сокол ест");
    }
}
