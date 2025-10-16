package CleanCode.practice_3.Task1;

public class InMemoryStorage implements UrlStorage{
    private  String shortUrl;
    private  String longUrl;

    private static   InMemoryStorage inMemoryStorage;

    public  static  InMemoryStorage getInstance(){
        if(inMemoryStorage==null){
            inMemoryStorage = new InMemoryStorage();
        }
        return  inMemoryStorage;
    }


    @Override
    public void save(String shortUrl, String longUrl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }


    @Override
    public String getShortUrl() {
        return shortUrl;
    }

    @Override
    public String getLongUrl() {
        return longUrl;
    }
}
