package CleanCode.practice_3.Task1;

public class UUIDStrategy implements ShorteningStrategy{
    @Override
    public void convert(String longUrl) {
        System.out.println(longUrl+" Конвертирован в UUID");
    }
}
