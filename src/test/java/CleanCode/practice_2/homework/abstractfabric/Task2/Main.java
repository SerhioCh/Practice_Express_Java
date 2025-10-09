package CleanCode.practice_2.homework.abstractfabric.Task2;

public class Main {
    public static void main(String[] args) {
        GUIFabric guiFabric;
        guiFabric = new MacOSFabric();
        guiFabric.createButton().print();
        guiFabric.createWindow().print();
        guiFabric = new WindowsFabric();
        guiFabric.createButton().print();
        guiFabric.createWindow().print();

    }
}
