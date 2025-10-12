package CleanCode.practice_3.Task2;

abstract class Video {
    private int id;
    private  String name;

    public Video(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract  void printFormatVideo();
}
