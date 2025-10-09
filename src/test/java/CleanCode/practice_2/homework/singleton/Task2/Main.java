package CleanCode.practice_2.homework.singleton.Task2;

public class Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.setRecordEvents("Запущено 21 событие");
        log1.setRecordsError("0 Ошибок");
        log1.setRecordWarnings("2 Предупреждения");
        System.out.println("----Лог 1 ----до изменений--------");
        log1.displayLog();

        Logger log2 = Logger.getInstance();
        log2.setRecordsError("2 Ошибки");
        System.out.println("----Лог 2 ----после изменений--------");
        log2.displayLog();
        System.out.println("----Лог 1 ----после изменений--------");
        log1.displayLog();


    }
}
