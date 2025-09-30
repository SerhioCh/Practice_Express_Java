package JavaDev.sobes.oop;

public class Lux extends Room{
    public Lux(int id, double cost, String status) {
        super(id, cost, status);
    }

    @Override
    void printInfoRooms() {
        System.out.println("Тип номера: Lux"+" Цена: "+ getCost());
    }

}
