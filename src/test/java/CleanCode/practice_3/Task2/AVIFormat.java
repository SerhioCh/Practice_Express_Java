package CleanCode.practice_3.Task2;

public class AVIFormat extends Video {

    public AVIFormat(int id, String name) {
        super(id, name);
    }

    @Override
    void printFormatVideo() {
        System.out.println("Видео сохранено в формате AVI");
    }
}

