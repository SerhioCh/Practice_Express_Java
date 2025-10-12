package CleanCode.practice_3.Task2;

public class Main {
    public static void main(String[] args) {
        Video video = new AVIFormat(1,"newVideoAvi");
        Video video2 = new MOVFormat(1,"newVideoMov");
        VideoService videoService = new VideoService(new AviVideoAdapter(),new MovVideoAdapter());

        videoService.uploadFile(video,"avi");

        System.out.println("----------------------------------------");
        videoService.uploadFile(video2,"mov");
    }
}
