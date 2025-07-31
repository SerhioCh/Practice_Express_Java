package practice_5.Restaurant;

public class Main {
    public static void main(String[] args) {
        HotDish pasta = new HotDish();
        Drink cola = new Drink();

        Menu m1 = new Menu();
        m1.addDish(pasta);
        pasta.setName("Паста");
        pasta.setTemperature(45);
        m1.printMenu();

        m1.addDish(cola);
        cola.setName("Кока-кола");
        cola.setValue(0.5);
        m1.printMenu();
    }
}
