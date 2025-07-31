package practice_5.Pets;

public class Cat implements Pets {
    @Override
    public void behaviorPets() {
        System.out.println("Кошка: играет");
    }

    @Override
    public void nutritionPets() {
        System.out.println("Кошка ест влажный корм");
    }
}
