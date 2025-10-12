package CleanCode.practice_3.Task1;

public class Base62Strategy implements ShorteningStrategy{
    @Override
    public void convert(String longUrl) {
        System.out.println(longUrl+" Конвертирован в Base62");
    }
}
