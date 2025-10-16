package CleanCode.practice_3.Task1;

public class UrlShortenerService {
    ShortenerFactory shortenerFactory;
    UrlStorage storage;

    public UrlShortenerService(ShortenerFactory shortenerFactory,UrlStorage storage) {
        this.shortenerFactory = shortenerFactory;
        this.storage = storage;
    }

    public  String shortenerUrl(String longUrl){
        String shortUrl = shortenerFactory.createStrategy().convert(longUrl);
        storage.save(shortUrl, longUrl);
        return shortUrl;
    }

    public  String expandUrl(String shortUrl){
        return storage.getLongUrl();
}
    }