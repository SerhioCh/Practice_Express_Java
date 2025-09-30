package JavaDev.practice_9.HomeWork.part_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_1 {

    List<String> words = Arrays.asList("Serega","Vitya","Pahaaaaa","Vanyaaaa","Jenok","Sasha");

    List <String> removeWordLessFiveLenghth = words.stream()
            .filter(w -> w.length()>5)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        Task_1 t = new Task_1();
        System.out.println(t.removeWordLessFiveLenghth);

    }
}
