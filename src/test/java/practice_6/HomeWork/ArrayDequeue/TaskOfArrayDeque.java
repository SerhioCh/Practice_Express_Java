package practice_6.HomeWork.ArrayDequeue;

import java.util.ArrayDeque;

public class TaskOfArrayDeque {
    ArrayDeque <Integer> numbers = new ArrayDeque<>();

    public  void undoOrder(){
     while (!numbers.isEmpty()){
         numbers.pollLast();
         System.out.println("Порядок извлечения: " + numbers);
     }
    }

    public static void main(String[] args) {
        TaskOfArrayDeque task = new TaskOfArrayDeque();

        task.numbers.add(10);
        task.numbers.add(11);
        task.numbers.add(25);
        task.numbers.add(64);
        task.numbers.add(44);
        System.out.println(task.numbers); // Задача 1 добавить и вывести 5 элементов
        task.undoOrder(); //Задача 2 обратный порядок извлечения
    }

}
