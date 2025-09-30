package JavaDev.practice_9.stream;

import java.util.Arrays;
import java.util.List;

public class FilterList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
      int sum =  numbers.stream()
                .filter(n -> n%2==0)
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println(sum);
    }
}
