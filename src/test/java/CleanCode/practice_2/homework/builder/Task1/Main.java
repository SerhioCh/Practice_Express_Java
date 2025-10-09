package CleanCode.practice_2.homework.builder.Task1;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Order order = new Order.OrderBuilder()
                .setPaymentMethod("Visa")
                .setProduct("Telephone")
                .build();
        Order order1 = new Order.OrderBuilder()
                .setPaymentMethod("MasterCard")
                .setDiscount(234.5)
                .build();
        shop.addOrder(order);
        shop.addOrder(order1);
    }



}
