package JavaDev.practice_9.practice_gpt;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 8, 10, 11);
        List<String> words = Arrays.asList("Serega", "Petya", "Vladimir", "ValerichNo", "Pahaaa");

        List<String> filtredWords = words.stream()
                .filter(w -> w.length() > 5)
                .collect(Collectors.toList());
        //  System.out.println(filtredWords);

        int  sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

       Optional <String> filtredByS = words.stream()
                .filter(n -> n.startsWith("V"))
                .findFirst();
        System.out.println(filtredByS.get());


        boolean numb = numbers.stream()
                .anyMatch(n -> n%2 ==0);
        System.out.println("Есть-ли в списке четные числа?:" + numb);

        Map<Character, List<String>> groupByFirstChar = words.stream()
                .collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println(groupByFirstChar);

        Double checkEvenNumber =  numbers.stream()
                .collect(Collectors.averagingInt(n -> n));


    }

}
