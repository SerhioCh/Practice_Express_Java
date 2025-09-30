package JavaDev.practice_5.Pets;

public class ManagerPets {
    Pets pet;

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    void behaviorPet(){
        pet.behaviorPets();
    }

    void nutritionPet(){
        pet.nutritionPets();
    }

}
