package CleanCode.practice_3.Task1;

public class Base62Strategy implements ShorteningStrategy{
    private static int counter = 0;
    @Override
    public String convert(String longUrl) {
        counter++;
        return "short" + counter;
    }
}
