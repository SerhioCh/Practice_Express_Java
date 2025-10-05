package CleanCode.practice_1;

public class Task2 {
    public static double calculateDiscount(double price, boolean isLoyalCustomer, boolean isFirstPurchase, boolean hasCoupon) {
        double discount = 0.0;

        if(isLoyalCustomer&& isFirstPurchase){
            discount = price *0.10;
        }
        else  if (hasCoupon){
            discount = price * 0.07;
        }
        else if (isLoyalCustomer){
            discount = price * 0.05;
        }
        else {
            discount = price * 0.02;
        }

        return price - discount;
    }


    public static void main(String[] args) {

        System.out.println(calculateDiscount(1000,true,true,false));
        System.out.println(calculateDiscount(1000,true,true,true));
        System.out.println(calculateDiscount(1000,false,true,true));
        System.out.println(calculateDiscount(1000,false,false,true));
        System.out.println(calculateDiscount(1000,false,false,false));
    }
}
