package CleanCode.practice_1.Task6;

/**
 Вынес метод летать в интерфейс, чтобы использовать его по назначению
 */
public class Main {
    public static void main(String[] args) {

        Bird penguin = new Penguin();
        Bird sokol = new Sokol();
        sokol.eat();
        ((Flyable)sokol).fly();
        penguin.eat();
    }

}
