package CleanCode.practice_2.homework.fabric.Task1;

public class CarFabric extends TransportFabric {
    @Override
    Transport createTransport() {
        return new Car();
    }
}
