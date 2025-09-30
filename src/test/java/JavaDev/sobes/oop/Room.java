package JavaDev.sobes.oop;

abstract class Room {
    private int id;
    private  double cost;
    private  String status;

    public Room(int id, double cost, String status) {
        this.id = id;
        this.cost = cost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    abstract void printInfoRooms();

    @Override
    public String toString() {
        return "Room{" +
                "Цена = " + cost +
                '}';
    }
}
