package JavaDev.practice_5.task_1;

public class Dispatcher {
    public  void  control(Transport transport){
        transport.start();

    }

    public  void printTransportDetails(Transport transport){
        System.out.println("Скорость транспорта: "+ transport.getSpeed());
        System.out.println("Вместимость транспорта: "+ transport.getCapacity());
    }

    public static void main(String[] args) {
        Transport car = new Car();
        Transport ship = new Ship();
        Transport plane = new Plane();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.control(car);
        dispatcher.printTransportDetails(car);
        dispatcher.control(ship);
        dispatcher.printTransportDetails(ship);
        dispatcher.control(plane);
        dispatcher.printTransportDetails(plane);


    }
}
