package practice_6.HomeWork.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TaskOfHashSet {
    HashSet <Integer> numbers = new HashSet<>();
    List<String> word = new ArrayList<>();


    public  boolean  checkContainsInHashSet (int number) {
      boolean cont =   numbers.contains(number);
      return  cont;
    }

    public  void generateToHashSet () {
        HashSet <String> hashWord = new HashSet<>(word);
        System.out.println(hashWord);
    }

    public static void main(String[] args) {

        TaskOfHashSet task = new TaskOfHashSet();
        task.numbers.add(5);
        task.numbers.add(53);
        task.numbers.add(1);
        task.numbers.add(2);
        task.numbers.add(3);
        task.word.add("Serega");
        task.word.add("Serega");
        task.word.add("Masha");
      //  System.out.println(task.numbers); // Задача 1 - вывести содержимое
      //  System.out.println(task.checkContainsInHashSet(52)); // Задача 2  Проверка содержания заданного значения
      //  System.out.println(task.word); // Показываю что вв ArrayList лежат дубли
        // task.generateToHashSet();  // Задача 3  возвращать коллекцию без дублей
        // Задача 4 решается так же через contains  если true выводить Слово есть в списке , если false выводить слова нет в списке
    }


    }
