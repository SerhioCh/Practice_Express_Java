package CleanCode.practice_1.Task5;

public class CreditCard implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата кредитной картой на сумму " + amount);
    }
}
