package CleanCode.practice_1.Task5;

public class Main {

    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod payPal = new PayPal();
        PaymentMethod bitCoin = new Bitcoin();

        creditCard.pay(3000);
        payPal.pay(1500);
        bitCoin.pay(6000);
    }

}
