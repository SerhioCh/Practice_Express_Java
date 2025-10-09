package CleanCode.practice_2.homework.facade.Task2;

public class Main {
    public static void main(String[] args) {
        LightOperation lightOperation = new LightOperation();
        ConditionerOperation conditionerOperation = new ConditionerOperation();
        AlarmSystemOperation alarmSystemOperation = new AlarmSystemOperation();

        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(lightOperation,conditionerOperation,alarmSystemOperation);

        smartHomeFacade.fullCycleOn();
        System.out.println("-----------------");
        smartHomeFacade.fullCycleOff();

// Можно создать методы под каждый  класс в фасаде, чтоб пользователь мог атамарно использовать каждый метод по включению или выключению отдельных приборов

    }
}
