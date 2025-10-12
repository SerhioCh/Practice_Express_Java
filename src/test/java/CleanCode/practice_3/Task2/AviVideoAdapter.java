package CleanCode.practice_3.Task2;

public class AviVideoAdapter implements  VideoAdapter{
    @Override
    public void convert(Video video) {
        System.out.println("Видео: "+ video.getName() + "  из AVI формата  конвертировано в формат MP4");
    }
}
