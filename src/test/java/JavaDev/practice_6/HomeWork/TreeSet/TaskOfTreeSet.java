package JavaDev.practice_6.HomeWork.TreeSet;

import java.util.TreeSet;

public class TaskOfTreeSet {

    TreeSet <Integer> numbers = new TreeSet<>();

    public  void maxAndMinNumbersOfTreeSet(int number){

      Integer minNumber =   numbers.floor(number);
        System.out.println(minNumber);

        Integer maxNumber = numbers.ceiling(number);

        System.out.println(maxNumber);

    }

    public static void main(String[] args) {
        TaskOfTreeSet task = new TaskOfTreeSet();

        task.numbers.add(5);
        task.numbers.add(4);
        task.numbers.add(7);
        task.numbers.add(25);
        task.numbers.add(72);
        task.numbers.add(72);
        // System.out.println(task.number);  //Задача 1 Вывел , числа отображаются в отсортированном порядке
        // Задача 2    В TreeSet по умолчанию нельзя добавить дубли
        //  task.maxAndMinNumbersOfTreeSet(9); Задача 3 вывожу максимальное и минимальное значение от заданного
    }

}
