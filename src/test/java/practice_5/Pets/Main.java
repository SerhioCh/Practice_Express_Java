package practice_5.Pets;

public class Main {
    public static void main(String[] args) {
        Pets dog = new Dog();
        Pets cat = new Cat();
        ManagerPets m1 = new ManagerPets();
        m1.setPet(dog);
        m1.behaviorPet();
        m1.nutritionPet();

    }
}
