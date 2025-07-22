package practice_2;

public class Laptop {
    final int  MAX_YEARS = 14;
    String brand;
    double price;

     Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    void  printInfo(){
        System.out.println("Ноутбук: "+ brand + " Цена: "+ price+" руб");
    }

    public static void main(String[] args) {
        Laptop l1 = new Laptop("Acer",53000);
        l1.printInfo();
        l1.setPrice(68800);
        l1.printInfo();
        int x =  l1.MAX_YEARS;
    }
}
