package CleanCode.practice_2.homework.adapter.Task1;

public class PdfProcessor  implements DocumentProcessor {
    @Override
    public void process() {
        System.out.println("Документ преобразован в PDF формат");
    }
}
