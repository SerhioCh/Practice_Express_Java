package practice_5.Museum;

public class Sculpture implements Exhibit{
    @Override
    public void conditions() {
        System.out.println("Скульптура требует постоянной реставрации");
    }

    @Override
    public void history() {
        System.out.println("Древняя скульптура V век до н.э");
    }
}
