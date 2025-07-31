package practice_5.Zoo;

public class Bird extends Animals {
    @Override
    void animalSound() {

        System.out.println("Чирик-Чирик");

    }

    @Override
    void animalsMove() {
        System.out.println("Птица: летает");
    }
}
