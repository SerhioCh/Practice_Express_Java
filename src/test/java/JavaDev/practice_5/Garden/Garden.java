package JavaDev.practice_5.Garden;

public class Garden {
    GardenPlants plants;

    public void setPlants(GardenPlants plants) {
        this.plants = plants;
    }

    void careGardenPlants(){
        plants.care();
    }
}
