package JavaDev.sobes.oop;

public class Standart extends Room {
    public Standart(int id, double cost, String status) {
        super(id, cost, status);
    }

    @Override
    void printInfoRooms() {
        System.out.println("Тип номера: Standart "+ " Цена: "+ getCost());
    }
}
