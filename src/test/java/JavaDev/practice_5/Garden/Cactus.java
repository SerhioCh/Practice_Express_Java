package JavaDev.practice_5.Garden;

public class Cactus implements GardenPlants {
    @Override
    public void care() {
        System.out.println("Для кактуса нужно много света, редкий полив");
    }
}
