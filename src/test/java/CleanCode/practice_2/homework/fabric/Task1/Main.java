package CleanCode.practice_2.homework.fabric.Task1;

public class Main {
    public static void main(String[] args) {
        TransportFabric transportFabric;
        transportFabric = new CarFabric();
        transportFabric.printShipping();
        transportFabric = new BicycleFabric();
        transportFabric.printShipping();
    }


}
