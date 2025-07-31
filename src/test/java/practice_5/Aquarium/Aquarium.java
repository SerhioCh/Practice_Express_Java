package practice_5.Aquarium;

public class Aquarium {
    SeaAnimal animal;

    public void setAnimal(SeaAnimal animal) {
        this.animal = animal;

    }
    void  behavior(){
        animal.move();
    }

}
