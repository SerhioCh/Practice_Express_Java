package JavaDev.practice_6.photo_editor;

import java.util.Stack;

public class PhotoEditor {
    private Stack <String> actions;

    public PhotoEditor(){
        this.actions = new Stack<>();
    }

    public void  addNewAction (String action) {
        actions.push(action);
    }

    public  void undoAction(){
        actions.pop();
    }

    public  void printActions(){
        System.out.println("Все действия:");
        actions.forEach(System.out::println);
    }

    // хранить последние действия
    // иметь возможность откатить последнее действие


}
