package practice_9.HomeWork.part_1;

import java.util.function.Function;

public class TaskOfFunction {
    Function <String,Integer> wordLength = w -> w.length();

    public static void main(String[] args) {
        TaskOfFunction t = new TaskOfFunction();
        System.out.println(t.wordLength.apply("Serega"));
    }
}

