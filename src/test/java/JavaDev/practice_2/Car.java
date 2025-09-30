package JavaDev.practice_2;

public class Car {
    String brand;
    int year;
    Car (String brand, int year){
        this.year = year;
        this.brand = brand;
    }
    String getBrand(){
        return this.brand;
    }
    int getYear(){
        return this.year;
    }
    void setYear (int year){
        this.year = year;
    }
    void setBrand(String brand){
        this.brand = brand;
    }
    void print(){
        System.out.println("Марка автомобиля: "+ brand);
        System.out.println("Год выпуска автомобиля: "+ year);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Jaguar",1998);
        car1.print();
        car1.setYear(1996);
        car1.print();
    }
}
