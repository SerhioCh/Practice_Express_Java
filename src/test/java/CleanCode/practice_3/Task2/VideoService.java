package CleanCode.practice_3.Task2;

public class VideoService {
    private  final VideoAdapter aviAdapter;
    private  final VideoAdapter movAdapter;

    public VideoService(VideoAdapter aviAdapter, VideoAdapter movAdapter) {
        this.aviAdapter = aviAdapter;
        this.movAdapter = movAdapter;
    }

    public  void uploadFile (Video video, String format){
        System.out.println("Началась загрузка видео: "+ video.getName());

        switch (format){
            case "avi":  aviAdapter.convert(video);
            break;
            case "mov":  movAdapter.convert(video);
                break;
        }

        System.out.println("Загрузка видео: " + video.getName()+ " в MP4 формате успешно завершена");
    }
}
