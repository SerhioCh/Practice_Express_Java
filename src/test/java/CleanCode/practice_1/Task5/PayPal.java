package CleanCode.practice_1.Task5;

public class PayPal implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата через PayPal на сумму " + amount);
    }
}
