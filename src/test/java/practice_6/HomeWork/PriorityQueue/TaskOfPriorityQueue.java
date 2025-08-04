package practice_6.HomeWork.PriorityQueue;

import java.util.PriorityQueue;

public class TaskOfPriorityQueue {
    PriorityQueue <Integer> numbers = new PriorityQueue<>();

    public  void printOrderDeleting(){
        while (!numbers.isEmpty()){
            numbers.poll();
            System.out.println("Порядок удаления: " + numbers);
        }
    }

    public static void main(String[] args) {
        TaskOfPriorityQueue task = new TaskOfPriorityQueue();

        task.numbers.add(5);
        task.numbers.add(6);
        task.numbers.add(9);
        task.numbers.add(11);
        task.numbers.add(25);
        task.printOrderDeleting(); // Задача 1 отобразить значения в порядке удаления

    }
}
