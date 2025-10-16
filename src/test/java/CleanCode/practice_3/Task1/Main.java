package CleanCode.practice_3.Task1;

public class Main {
    public static void main(String[] args) {
        InMemoryStorage inMemoryStorage = InMemoryStorage.getInstance();
        ShortenerFactory factory = new ShortenerFactory(new Base62Strategy());
        UrlShortenerService  shortenerService = new UrlShortenerService(factory,inMemoryStorage);

        String longUrl = "https://example.com/very/long";
        String shortUrl = shortenerService.shortenerUrl(longUrl);
        System.out.println("ShortUrl" + shortUrl);
        System.out.println("----------------------------------------------");

        String expandedUrl = shortenerService.expandUrl(shortUrl);
        System.out.println("LongUrl: " + expandedUrl);


    }
}
