package CleanCode.practice_2.homework.abstractfabric.Task1;

public class ClassicChair implements Chair {
    @Override
    public void setOn() {
        System.out.println("Использовать классический стул");
    }
}
