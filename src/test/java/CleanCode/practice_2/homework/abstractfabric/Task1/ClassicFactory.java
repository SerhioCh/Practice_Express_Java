package CleanCode.practice_2.homework.abstractfabric.Task1;

public class ClassicFactory implements  FabricFactory {
    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public Table createTable() {
        return new ClassicTable();
    }
}
