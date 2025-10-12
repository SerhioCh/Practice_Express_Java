package CleanCode.practice_3.Task2;

public class MOVFormat extends Video {

    public MOVFormat(int id, String name) {
        super(id, name);
    }

    @Override
    void printFormatVideo() {
        System.out.println("Видео сохранено в формате MOV");
    }
}
