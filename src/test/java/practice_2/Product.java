package practice_2;

public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    double applyDiscount(double discount){
        return  price-=discount;
    }
    void printInfo(){
        System.out.println("Товар: "+ name + " Цена: "+ price+" руб");
    }

    public static void main(String[] args) {
        Product p1 = new Product("Cок",250);
        p1.printInfo();
        p1.setPrice(302);
        p1.printInfo();
        p1.applyDiscount(100);
        p1.printInfo();
    }
}
