package JavaDev.practice_5.Pets;

public class Dog implements Pets {
    @Override
    public void nutritionPets() {
        System.out.println("Собака: гуляет");
    }

    @Override
    public void behaviorPets() {
        System.out.println("Собака ест сухой корм");
    }
}
