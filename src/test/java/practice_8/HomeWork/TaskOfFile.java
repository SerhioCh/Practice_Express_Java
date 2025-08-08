package practice_8.HomeWork;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskOfFile {
    public static void main(String[] args) throws FileNotFoundException {
       try {
           FileReader file = new FileReader("data.txt");
       }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}
