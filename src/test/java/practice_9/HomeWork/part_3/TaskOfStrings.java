package practice_9.HomeWork.part_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskOfStrings {
    List<String> words = Arrays.asList("Serega","Vitya","Pahaaaaa","Vanyaaaa","Jenok","Sasha");

    List <String> wordStatsCharS = words.stream()
            .filter(w -> w.startsWith("S"))
            .collect(Collectors.toList());

    public static void main(String[] args) {

        TaskOfStrings t = new TaskOfStrings();
        System.out.println(t.wordStatsCharS); // Задача 4
    }
}
