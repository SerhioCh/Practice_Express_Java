package practice_5.Park;

public class Carousel implements  Attraction{
    @Override
    public void info() {
        System.out.println("Ощущения невесомости");
    }

    @Override
    public void service() {
        System.out.println("Карусель техническое обслуживание");
    }
}
