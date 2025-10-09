package CleanCode.practice_2.homework.abstractfabric.Task2;

public class WindowsFabric implements GUIFabric{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }
}
