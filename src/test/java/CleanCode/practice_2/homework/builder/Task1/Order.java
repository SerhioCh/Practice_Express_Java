package CleanCode.practice_2.homework.builder.Task1;

public class Order {
    String product;
    double discount;
    String paymentMethod;

    public Order(String product, double discount, String paymentMethod) {
        this.product = product;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
    }
    public Order(OrderBuilder orderBuilder) {
        this.product = orderBuilder.product;
        this.discount = orderBuilder.discount;
        this.paymentMethod = orderBuilder.paymentMethod;
    }

    @Override
    public String toString() {
        return "Продукт: " + product  +
                ", Скидка: " + discount +
                ", Способ оплаты: " + paymentMethod ;
    }

    static class  OrderBuilder{
        String product;
        double discount;
        String paymentMethod;

        public OrderBuilder setProduct(String product) {
            this.product = product;
            return this;
        }

        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public  Order build (){
            return  new Order(this);
        }

    }

}
