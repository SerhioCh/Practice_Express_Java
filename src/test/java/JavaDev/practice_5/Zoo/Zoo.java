package JavaDev.practice_5.Zoo;

public class Zoo {
    Animals animals;

    void setAnimal(Animals animal){
        this.animals = animal;
    }
    void soundOfAnimal(){
        if (animals!=null){
        animals.animalSound();}
        else {
            System.out.println("Задайте животное");
        }
    }
    void  moveOfAnimals(){
        if(animals!=null){
        animals.animalsMove();}
        else {
            System.out.println("Задайте животное");
        }
    }
    void removeAnimalFromZoo(){
        animals = null;
    }

}
