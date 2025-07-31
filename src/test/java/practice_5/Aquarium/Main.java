package practice_5.Aquarium;

public class Main {
    public static void main(String[] args) {
        SeaAnimal ribaMolot = new Shark();
        SeaAnimal zvezda  = new SeaStar();

        Aquarium aqua1 = new Aquarium();
        aqua1.setAnimal(ribaMolot);
        aqua1.behavior();

        aqua1.setAnimal(zvezda);
        aqua1.behavior();

    }
}
