package JavaDev.practice_9.HomeWork.part_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_4 {

    List<Integer> numbers = Arrays.asList(3,4,7,5,6,11,24,25,34,34,3);

    List <Integer>  squareOfNumber = numbers.stream()
            .map(n -> n*n)
            .collect(Collectors.toList());

    List <Integer>  removeDublicat = numbers.stream()
            .distinct()
            .collect(Collectors.toList());

    public static void main(String[] args) {
        Task_4 t = new Task_4();
        System.out.println(t.squareOfNumber); // Задача 4
        System.out.println(t.removeDublicat); // Задача 5
    }
}
