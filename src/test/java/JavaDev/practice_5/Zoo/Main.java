package JavaDev.practice_5.Zoo;

public class Main {

    public static void main(String[] args) {
        Animals vorobei = new Bird();
        Animals slon = new Elephant();

        Zoo zo = new Zoo();
        zo.setAnimal(vorobei);
        zo.moveOfAnimals();
        zo.soundOfAnimal();
        zo.removeAnimalFromZoo();
        zo.soundOfAnimal();           // Здесь мы показываем, что выводится сообщение когда animals = null
        zo.setAnimal(slon);
        zo.moveOfAnimals();


    }
}
