package practice_6.HomeWork.LinkedHashSet;

import java.util.LinkedHashSet;

public class TaskOfLinkedHashSet {
    LinkedHashSet <String> words = new LinkedHashSet<>();

    public  void  orderOfLinkedHashSet(){
        for (String s : words){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        TaskOfLinkedHashSet task = new TaskOfLinkedHashSet();

        task.words.add("Serega");
        task.words.add("Vasya");
        task.words.add("Petya");
        task.words.add("Masha");
        task.words.add("Lev");
        task.words.add("Serega");

       //  task.orderOfLinkedHashSet(); // Задача 1  элементы были добавлены в порядке добавления
       // System.out.println(task.words); // Задача  2 дубль не сохраняется (конечно можно сделать метод contains word и если совпадает выводить сообщение , но смысла нет)

    }
}
