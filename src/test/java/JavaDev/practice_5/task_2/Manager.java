package JavaDev.practice_5.task_2;

public class Manager {
    public  void manage (Item item){
        item.print();
    }


    public static void main(String[] args) {
        Item mug = new Item("Кружка",100,2);
        Item microphone = new Electronics("Микрофон",10000,1);
        Item dress = new Clothes("Платье",5000,3);


        Manager kostya = new Manager();
        kostya.manage(mug);
        kostya.manage(microphone);
        kostya.manage(dress);
    }
}
