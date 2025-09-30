package JavaDev.practice_5.Park;

public class RollerCoaster implements Attraction {
    @Override
    public void info() {
        System.out.println("Быстрые и шумно");
    }

    @Override
    public void service() {
        System.out.println("Проверка безопасности горки");
    }
}
