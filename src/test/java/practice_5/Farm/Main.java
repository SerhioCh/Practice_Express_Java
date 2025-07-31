package practice_5.Farm;

public class Main {
    public static void main(String[] args) {
        FarmAnimal burenka = new Cow();
        FarmAnimal cipa = new Chicken();

        Farm f = new Farm();

        f.setAnimal(burenka);
        f.lifeCycleAnimal();

        f.setAnimal(cipa);
        f.lifeCycleAnimal();

    }
}
