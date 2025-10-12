package CleanCode.practice_3.Task1;

public class ShortenerFactory {
    private  final  ShorteningStrategy strategy;

    public ShortenerFactory(ShorteningStrategy strategy) {
        this.strategy = strategy;
    }

    public  ShorteningStrategy createStrategy(){
        return  strategy;
    }
}
