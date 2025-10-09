package CleanCode.practice_2.homework.adapter.Task1;

public class Main {
    public static void main(String[] args) {
        DocumentProcessor documentProcessor = new DocumentAdapter(new PdfProcessor());
        documentProcessor.process();
    }
}
