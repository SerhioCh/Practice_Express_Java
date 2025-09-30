package JavaDev.practice_6.RestarauntManager;

public class Main {
    public static void main(String[] args) {
        RestaurantManager m = new RestaurantManager();
        m.addNewOrder("Картошка фри");
        m.addNewOrder("Спаггети");
        m.addNewOrder("Маргарита");
        m.printOrders();



        m.deleteOrder("Спаггети");
        m.printOrders();

    }
}
