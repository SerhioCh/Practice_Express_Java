package CleanCode.practice_2.homework.facade.Task2;

public class SmartHomeFacade {
    LightOperation lightOperation;
    ConditionerOperation conditionerOperation;
    AlarmSystemOperation alarmSystemOperation;

    public SmartHomeFacade(LightOperation lightOperation, ConditionerOperation conditionerOperation, AlarmSystemOperation alarmSystemOperation) {
        this.lightOperation = lightOperation;
        this.conditionerOperation = conditionerOperation;
        this.alarmSystemOperation = alarmSystemOperation;
    }

    public  void fullCycleOn(){
        lightOperation.turnOnLight();
        conditionerOperation.turnOnConditioner();
        alarmSystemOperation.turnOnAlarmSystem();
    }

    public  void fullCycleOff(){
        lightOperation.turnOffLight();
        conditionerOperation.turnOffConditioner();
        alarmSystemOperation.turnOffAlarmSystem();
    }
}
