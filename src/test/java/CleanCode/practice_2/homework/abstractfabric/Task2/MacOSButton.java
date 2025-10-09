package CleanCode.practice_2.homework.abstractfabric.Task2;

public class MacOSButton implements Button{
    @Override
    public void print() {
        System.out.println("Кнопка отображается на МакОс");
    }
}
