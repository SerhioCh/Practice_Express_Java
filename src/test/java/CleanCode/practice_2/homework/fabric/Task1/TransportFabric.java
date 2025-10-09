package CleanCode.practice_2.homework.fabric.Task1;

abstract class TransportFabric {
    abstract  Transport createTransport();

    public  void printShipping(){
        Transport transport = createTransport();
        transport.shipping();
    }
}
