package JavaDev.practice_9.HomeWork.part_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_2 {
    List<Integer>  numbers = Arrays.asList(3,4,7,5,6,11,24,25,34);

    List <Integer> numbersDevideOfFiveWithoutRemainder = numbers.stream()
            .filter(n -> n%5==0)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        Task_2 t = new Task_2();
        System.out.println(t.numbersDevideOfFiveWithoutRemainder);
    }
}

