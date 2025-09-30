package JavaDev.practice_6.RestarauntManager;

import java.util.LinkedList;

public class RestaurantManager {
    private LinkedList <String> orders;
    RestaurantManager(){
        this.orders = new LinkedList<>();
    }
    // добавлять заказ в конец очереди
    public  void addNewOrder (String order){
        orders.addLast(order);
    }
    // обрабатывать заказ из начала очереди
    public  String getNextOrder(){
        return  orders.poll();
    }
    // удалять заказ в любом месте очереди
    public  void deleteOrder (String order){
        orders.remove(order);
    }

    public  void printOrders(){
        System.out.println("Все заказы: ");
        orders.forEach(order -> System.out.println(order));
        System.out.println();
    }
}
