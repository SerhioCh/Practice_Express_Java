package practice_9.HomeWork.part_1;

import java.util.function.Predicate;

public class TaskOfPredicate {

    Predicate <Integer> checkEvenNumber =  n -> n%2==0;

    public static void main(String[] args) {

       TaskOfPredicate t = new TaskOfPredicate();
        System.out.println( "Является ли число четным ? "+  t.checkEvenNumber.test(7));
    }
}
