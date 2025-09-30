package JavaDev.practice_9.practice_gpt;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Task1 {

    public static   void checkChetnoehislo(int number) {
        Predicate <Integer> isEven = n -> n%2==0;
        System.out.println("Число " + number  + " четное? "+ isEven.test(number));
    }

    public  static void checkLength(String word){
        Function <String,Integer> wordLength = String::length;
        System.out.println(wordLength.apply(word));
    }
    public static   void printWord (String word){
        Consumer<String> wordPrint = System.out::println;
        wordPrint.accept(word);

    }

    public static void main(String[] args) {
checkChetnoehislo(7);
checkLength("Serega");
printWord("Serega");

    }
}