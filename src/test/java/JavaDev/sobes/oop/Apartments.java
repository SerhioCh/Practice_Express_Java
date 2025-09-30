package JavaDev.sobes.oop;

public class Apartments extends Room{
    public Apartments(int id, double cost, String status) {
        super(id, cost, status);
    }

    @Override
    void printInfoRooms() {
        System.out.println("Тип номера: Apartments"+" Цена: "+ getCost());
    }
}
