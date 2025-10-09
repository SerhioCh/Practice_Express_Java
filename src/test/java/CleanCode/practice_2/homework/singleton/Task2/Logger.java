package CleanCode.practice_2.homework.singleton.Task2;

public class Logger {
    private  String recordEvents;
    private  String  recordsError;
    private  String recordWarnings;

    private Logger() {
        this.recordEvents = "defaultEvents";
        this.recordsError = "defaultError";
        this.recordWarnings = "defaultWarnings";
    }

    private static   Logger logger;

    public  static  Logger getInstance(){
        if(logger==null){
            logger = new Logger();
        }
        return  logger;
    }

    public String getRecordEvents() {
        return recordEvents;
    }

    public void setRecordEvents(String recordEvents) {
        this.recordEvents = recordEvents;
    }

    public String getRecordsError() {
        return recordsError;
    }

    public void setRecordsError(String recordsError) {
        this.recordsError = recordsError;
    }

    public String getRecordWarnings() {
        return recordWarnings;
    }

    public void setRecordWarnings(String recordWarnings) {
        this.recordWarnings = recordWarnings;
    }

    public void displayLog (){
        System.out.println("Запись информации о событиях: "+ getRecordEvents() + " Запись ошибок: "+ getRecordsError()+" Запись предупреждений: "+ getRecordWarnings());
    }
}
