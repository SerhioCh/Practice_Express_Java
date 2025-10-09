package CleanCode.practice_2.homework.singleton.Task1;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    public String pathToSaveFile;
    DbConfig dbConfig;
    SettingLog settingLog;

    private ConfigurationManager() {
        this.pathToSaveFile = "default";
        this.dbConfig = new DbConfig("defaultUrl","DefaultUser","qwerty");
        this.settingLog = new SettingLog("defaultLog","/src/defaultPath/defaultLogConfig.txt");
    }


    public static   ConfigurationManager getInstance(){
        if(instance==null){
            instance= new ConfigurationManager();
        }
        return  instance;
    }

    public  void displayConfig(){
        System.out.println(pathToSaveFile);
        instance.dbConfig.displayDbConfig();
        instance.settingLog.displayLog();
    }

    public void setPathToSaveFile(String pathToSaveFile) {
        this.pathToSaveFile = pathToSaveFile;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public void setSettingLog(SettingLog settingLog) {
        this.settingLog = settingLog;
    }
}
