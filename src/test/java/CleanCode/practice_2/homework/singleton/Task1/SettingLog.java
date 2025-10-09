package CleanCode.practice_2.homework.singleton.Task1;

public class SettingLog {
    private  String levelLog;
    private  String pathToLogFile;

    public SettingLog(String levelLog, String pathToLogFile) {
        this.levelLog = levelLog;
        this.pathToLogFile = pathToLogFile;
    }

    public String getLevelLog() {
        return levelLog;
    }

    public String getPathToLogFile() {
        return pathToLogFile;
    }

    public  void displayLog (){
        System.out.println("Уровень логирования: "+ getLevelLog()+ " Путь к файлу: "+ getPathToLogFile());
    }
}
