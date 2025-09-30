package JavaDev.practice_5.Park;

public class Main {
    public static void main(String[] args) {
        Attraction roller = new RollerCoaster();
        Attraction carousel = new Carousel();

        ParkAttraction p = new ParkAttraction();

        p.setAttraction(roller);
        p.sensationsFromAttraction();
        p.maintanenceAttraction();


        p.setAttraction(carousel);
        p.sensationsFromAttraction();
        p.maintanenceAttraction();

    }
}
