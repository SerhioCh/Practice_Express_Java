package JavaDev.practice_6.HomeWork.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class TaskOfLinkedList {
    LinkedList <String> words = new LinkedList<>();


    public  void  taskProcessing (){
        while(!words.isEmpty()){
            words.poll();
            System.out.println("Обработано задач: "+ words);
        }
    }
    public  void firstElementsLinkedList (){
        System.out.println(words.getFirst());
    }
    public  void lastElementsLinkedList (){
        System.out.println(words.getLast());
    }

    public  void iterationLinkedList () {
        System.out.println("Прямой проход");
        ListIterator <String> forwardIterator = words.listIterator();
        while (forwardIterator.hasNext()){
            String element = forwardIterator.next();
            System.out.println(element);
        }

        System.out.println("\nОбратный проход");
        ListIterator <String> reverseIterator = words.listIterator(words.size());
        while (reverseIterator.hasPrevious()){
            String element = reverseIterator.previous();
            System.out.println(element);
        }
    }



    public static void main(String[] args) {
        TaskOfLinkedList task = new TaskOfLinkedList();
        task.words.add("Serega");
        task.words.add("Vasya");
        task.words.add("Petya");
        task.words.add("Masha");
        task.words.add("Irina");
       // System.out.println(task.words); // Задача 1 - Вывести значения из  LinkedList
       // task.taskProcessing(); // Задача 2 - Реализована очередь
       // task.firstElementsLinkedList(); // Задача 3  - вывести первое значение из LinkedList
       // task.lastElementsLinkedList(); // Задача 3   - вывести второе значение из LinkedList
       // Задачу 4 решил в ArrayList логика одна
       //  task.iterationLinkedList();  // Задача 5 - вывести в прямом порядке и вывести в обратном порядке

    }
}
