package practice_9.HomeWork.part_4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupInteger {

    List<Integer> numbers = Arrays.asList(3,4,7,5,6,11,24,25,34);

    Map<String, List<Integer>> groupEvenOrOddNumbers =  numbers.stream()
            .collect(Collectors.groupingBy(
                    n -> n%2==0 ? "Even ":"Odd "
            ));

     double avgNumbers = numbers.stream()
            .collect(Collectors.averagingInt(n -> n));

    public static void main(String[] args) {
        GroupInteger g = new GroupInteger();
        System.out.println(g.groupEvenOrOddNumbers); // Задача 2
        System.out.println("Cреднее значение из массива: "+ g.avgNumbers); // Задача 3

    }
}
