package CleanCode.practice_1.Task5;

public class Bitcoin implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}
