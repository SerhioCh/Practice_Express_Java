package CleanCode.practice_2.homework.fabric.Task1;

public class BicycleFabric extends TransportFabric {
    @Override
    Transport createTransport() {
        return new Bicycle();
    }
}
