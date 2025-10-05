package CleanCode.practice_1.Task5;

public class PaymentProcessor {

    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}