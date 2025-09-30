package JavaDev.practice_6.photo_editor;

public class Main {
    public static void main(String[] args) {
        PhotoEditor photoEditor = new PhotoEditor();

        photoEditor.addNewAction("Корректировка глаз");
        photoEditor.addNewAction("Корректировка ушей");
        photoEditor.addNewAction("Корректировка носа");
        photoEditor.printActions();

        photoEditor.undoAction();
        photoEditor.printActions();
    }
}
