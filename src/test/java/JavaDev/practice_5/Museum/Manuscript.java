package JavaDev.practice_5.Museum;

public class Manuscript implements Exhibit{
    @Override
    public void history() {
        System.out.println("Рукопись X век н.э");
    }

    @Override
    public void conditions() {
        System.out.println("Рукопись требует контролируемой влажности");
    }
}
