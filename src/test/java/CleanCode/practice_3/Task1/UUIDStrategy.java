package CleanCode.practice_3.Task1;

import java.util.UUID;

public class UUIDStrategy implements ShorteningStrategy{
    @Override
    public String convert(String longUrl) {
        return UUID.randomUUID().toString().substring(0,8);
    }
}
