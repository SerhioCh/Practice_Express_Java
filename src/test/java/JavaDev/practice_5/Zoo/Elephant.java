package JavaDev.practice_5.Zoo;

public class Elephant extends Animals {
    @Override
    void animalsMove() {
        System.out.println( "Слон: ходит");
    }

    @Override
    void animalSound() {
        System.out.println("Слон: трубит");
    }
}
