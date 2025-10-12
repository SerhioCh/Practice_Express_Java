package CleanCode.practice_3.Task2;

public class MovVideoAdapter implements  VideoAdapter{
    @Override
    public void convert(Video video) {
        System.out.println("Видео : "+ video.getName() + "  из MOV формата  конвертировано в формат MP4");
    }
}
