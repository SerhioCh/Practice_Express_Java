package CleanCode.practice_3.Task1;

public class InDbStorage implements UrlStorage {
    private  String shortUrl;
    private  String longUrl;

    private static   InDbStorage inDbStorage;

    public  static  InDbStorage getInstance(){
        if(inDbStorage==null){
            inDbStorage = new InDbStorage();
        }
        return  inDbStorage;
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
