package CleanCode.practice_2.homework.singleton.Task1;

public class DbConfig {
    private  String url;
    private  String username;
    private  String password;

    public DbConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public  void  displayDbConfig(){
        System.out.println("Url: "+ getUrl() + " Имя: "+ getUsername());
    }
}
