package practice_6.HomeWork.ArrayList;

import org.testng.util.TimeUtils;

import java.util.ArrayList;

public class TaskOfArrayList {
    ArrayList <Integer> numbers  = new ArrayList<>();
    ArrayList <String> word = new ArrayList<>();


    public  void  checkEvenNumbers (){
        for (int i =0 ; i<numbers.size();i++){
           Integer currentNumber = numbers.get(i);
           if (currentNumber%2==0){
               System.out.print(currentNumber+" ");
           }
        }
    }
    public  void checkMaxLineWord () {
        if(word.isEmpty()){
            throw  new IndexOutOfBoundsException("Добавьте значение в массив");
        }
        String maxlengthWord = word.get(0);
        for (int i =0 ; i<word.size();i++){
            String currentWord = word.get(i);
            if (currentWord.length()>maxlengthWord.length()){
                maxlengthWord = currentWord;
            }
        }
        System.out.println("Самая длинная строка: "+ maxlengthWord);
    }

public   void  sumOfNumbersArray () {
    Integer number = 0;
    for (int i = 0; i < numbers.size(); i++) {
        Integer currentNumber =  numbers.get(i);
        number+=currentNumber;
    }
    System.out.println(number);
}

public  void maxNumberOfArray(){
        Integer maxNumber = numbers.get(0);
        for (int i =0; i<numbers.size();i++){
            Integer currentNumber = numbers.get(i);
            if (currentNumber>maxNumber){
                maxNumber = currentNumber;
            }
        }
    System.out.println(maxNumber);
    }

    public static void main(String[] args) {
        TaskOfArrayList task = new TaskOfArrayList();
        task.numbers.add(7);
        task.numbers.add(2);
        task.numbers.add(4);
        task.numbers.add(6);
        task.numbers.add(5);
//        task.word.add("Serrrgooooo");
//        task.word.add("Vladqqq1111111111");
//        task.word.add("Roma");
        //   System.out.println(task.numbers); // Задача 1 - Вывести весь список из  ArrayList
        //  task.checkEvenNumbers();  // Задача 2 - Вывести четные числа из  ArrayList
        try {
            task.checkMaxLineWord();   // Задача 3 - выводит самую длинную строку из  ArrayList
        }
        catch (IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }
        //  task.sumOfNumbersArray(); // Задача 4 - выводит сумму всех чисел  ArrayList
        //  task.maxNumberOfArray(); // Задача 5 - выводит максимальное значение из ArrayList

    }

}
