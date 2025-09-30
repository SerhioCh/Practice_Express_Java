package JavaDev.practice_9.HomeWork.part_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindMaxAndMinAndSum {
    List<Integer> numbers = Arrays.asList(3,4,7,5,6,11,24,25,34);

    Optional<Integer> maxNumbers = numbers.stream()
            .max(Comparator.naturalOrder());
    Optional<Integer> minNumbers = numbers.stream()
            .max(Comparator.reverseOrder());
    int sumOfNumbers = numbers.stream()
            .mapToInt(n -> n)
            .sum();

    boolean evenNumbers = numbers.stream()
            .anyMatch(n -> n%5==0);



    public static void main(String[] args) {
        FindMaxAndMinAndSum f = new FindMaxAndMinAndSum();

       // System.out.println(f.maxNumbers.get()); //Задача 1
        //System.out.println(f.minNumbers.get()); // Задача 2
        //  System.out.println(f.sumOfNumbers); // Задача 3
      //  System.out.println("В списке есть число которое делится на 5 без остатка "+ f.evenNumbers); // Задача 5
    }
}
