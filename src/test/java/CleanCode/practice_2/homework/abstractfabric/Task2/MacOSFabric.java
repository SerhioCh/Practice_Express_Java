package CleanCode.practice_2.homework.abstractfabric.Task2;

public class MacOSFabric implements GUIFabric{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Window createWindow() {
        return new MacOSWindow();
    }
}
