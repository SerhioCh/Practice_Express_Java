package JavaDev.practice_5.Park;

public class ParkAttraction {
    Attraction attraction;

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    void sensationsFromAttraction(){
        attraction.info();
    }
    void  maintanenceAttraction(){
        attraction.service();
    }
}
