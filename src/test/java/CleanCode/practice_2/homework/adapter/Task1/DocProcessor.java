package CleanCode.practice_2.homework.adapter.Task1;

public class DocProcessor implements DocumentProcessor {
    @Override
    public void process() {
        System.out.println("Документ преобразован в Док формат");
    }
}
