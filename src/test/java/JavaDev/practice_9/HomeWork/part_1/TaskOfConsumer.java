package JavaDev.practice_9.HomeWork.part_1;

import java.util.function.Consumer;

public class TaskOfConsumer {
    Consumer <String> word = System.out::println;

    public static void main(String[] args) {

        TaskOfConsumer t = new TaskOfConsumer();
        t.word.accept("Serega");
    }

}
