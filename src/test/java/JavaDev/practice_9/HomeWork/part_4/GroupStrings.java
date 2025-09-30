package JavaDev.practice_9.HomeWork.part_4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStrings {

    List<String> words = Arrays.asList("Serega","Vitya","Pahaaaaa","Vanyaaaa","Jenok","Sasha");

    Map <Character, List <String>> wordsGroupByCharcter = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0)));

    public static void main(String[] args) {
        GroupStrings g = new GroupStrings();
        System.out.println(g.wordsGroupByCharcter);
    }
}
