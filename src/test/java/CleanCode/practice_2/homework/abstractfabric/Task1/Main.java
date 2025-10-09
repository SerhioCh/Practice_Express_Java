package CleanCode.practice_2.homework.abstractfabric.Task1;

public class Main {
    public static void main(String[] args) {
        FabricFactory fabricFactory;
        fabricFactory = new ClassicFactory();
        fabricFactory.createChair().setOn();
        fabricFactory.createTable().use();
        fabricFactory = new ModernFabric();
        fabricFactory.createChair().setOn();
        fabricFactory.createTable().use();
    }
}
