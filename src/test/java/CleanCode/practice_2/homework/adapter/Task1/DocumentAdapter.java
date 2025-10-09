package CleanCode.practice_2.homework.adapter.Task1;

public class DocumentAdapter implements DocumentProcessor {
    PdfProcessor pdfProcessor;

    public DocumentAdapter(PdfProcessor pdfProcessor) {
        this.pdfProcessor = pdfProcessor;
    }

    @Override
    public void process() {
       pdfProcessor.process();
        System.out.print( " - после адаптирован в формат Док");
    }
}
