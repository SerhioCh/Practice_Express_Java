package CleanCode.practice_2.homework.abstractfabric.Task1;

public class ModernFabric implements FabricFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
