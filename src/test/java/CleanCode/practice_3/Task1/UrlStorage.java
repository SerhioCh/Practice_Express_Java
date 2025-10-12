package CleanCode.practice_3.Task1;

public interface UrlStorage {
    public  void save(String shortUrl,String longUrl);
    public  String getShortUrl();
    public  String getLongUrl();
}
