package JavaDev.practice_5.Farm;

public class Farm {
    FarmAnimal animal;

    public void setAnimal(FarmAnimal animal) {
        this.animal = animal;
    }

    void lifeCycleAnimal(){
        animal.care();
        animal.feed();
        animal.produce();
    }
}
