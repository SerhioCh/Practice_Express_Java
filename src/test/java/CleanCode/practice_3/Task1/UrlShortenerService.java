package CleanCode.practice_3.Task1;

public class UrlShortenerService {
    ShortenerFactory shortenerFactory;
    UrlStorage storage;

    public UrlShortenerService(ShortenerFactory shortenerFactory) {
        this.shortenerFactory = shortenerFactory;
    }

    public  String shortenerUrl(String longUrl){
        String shortUrl = longUrl.substring(0,15);
        return  shortUrl;
    }

    public  String expandUrl(String shortUrl){
        String longUrl = shortUrl.substring(0,19);
        return  longUrl;
}
    }