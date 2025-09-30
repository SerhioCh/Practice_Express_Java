package JavaDev.practice_5.Garden;

public class Main {
    public static void main(String[] args) {
        GardenPlants orchid = new Orchid();
        GardenPlants cactus = new Cactus();

        Garden g = new Garden();
        g.setPlants(orchid);
        g.careGardenPlants();

        g.setPlants(cactus);
        g.careGardenPlants();
    }
}
