package JavaDev.practice_9.stream;

import java.util.*;
import java.util.stream.Collectors;

public class SortedUniqeElements {
    //список с дублирующими значениями
    // вывести все уникальные значения
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,3,1,5,4,7);

        List<Integer> uniqueSorted = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(uniqueSorted);

        OptionalInt maxInt = uniqueSorted.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println(maxInt);
    }
}
