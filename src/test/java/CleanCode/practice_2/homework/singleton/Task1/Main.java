package CleanCode.practice_2.homework.singleton.Task1;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        config1.setDbConfig(new DbConfig("google.com","serega","12345"));
        config1.setSettingLog(new SettingLog("high","src/newPath"));
        config1.setPathToSaveFile("newPath");
        System.out.println("-----Старое значение конфига 1--------");
        config1.displayConfig();

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        config2.setPathToSaveFile("oldPath");
        System.out.println("-----Измененный  конфиг 2--------");
        config2.displayConfig();
        System.out.println("-----Новое значение конфига 1--------");
        config1.displayConfig();




    }
}
