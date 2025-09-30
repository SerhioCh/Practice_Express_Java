package JavaDev.practice_5.Museum;

public class Main {
    public static void main(String[] args) {
        Exhibit pharaon = new Sculpture();
        Exhibit letopisVremenihLet = new Manuscript();

        Museum m = new Museum();
        m.setExhibit(pharaon);
        m.showExhibit();

        m.setExhibit(letopisVremenihLet);
        m.showExhibit();
    }
}
