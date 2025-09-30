package JavaDev.practice_9.HomeWork.part_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    List<String> words = Arrays.asList("Serega","Vitya","Pahaaaaa","Vanyaaaa","Jenok","Sasha");

    List<Integer> wordLength = words.stream()
            .map(String::length)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        Task3 t = new Task3();

        System.out.println(t.wordLength);
    }
}
