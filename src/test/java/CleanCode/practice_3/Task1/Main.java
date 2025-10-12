package CleanCode.practice_3.Task1;

public class Main {
    public static void main(String[] args) {
        InMemoryStorage inMemoryStorage = new InMemoryStorage();
        UrlShortenerService  shortenerService = new UrlShortenerService(new ShortenerFactory(new Base62Strategy()));
        inMemoryStorage.save("https://example.com","https://example.com/very/long");
        shortenerService.shortenerFactory.createStrategy().convert(inMemoryStorage.getLongUrl());
        String shortUrl = shortenerService.shortenerUrl(inMemoryStorage.getLongUrl());
        System.out.println("ShortUrl: "+ shortUrl);

        System.out.println("----------------------------------------------");

        String longUrl = shortenerService.expandUrl(inMemoryStorage.getShortUrl());
        System.out.println("LongUrl: "+ longUrl);
    }
}
