package practice_4.HomeWork;

import java.util.Scanner;

public class TasksOfWhile {
    public  static  void factorialOfNumber() {                                       //Задача 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int result =1;
        int i =1;
        while (i<=number){
            result= result*i;
            i++;
        }
        System.out.println("Факториал веденного числа: " + result);
    }

    public  static  void evenNumbersForUserNumber() {                                       //Задача 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int i = 1;
        while (i<=number){
            if (i%2==0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public  static  void countDownForUserNumber() {                                       //Задача 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int i = 1;
        while (i<number){     // Если число отрицательное тогда сразу сработает false и нет смысла писать дополнительную проверку, метод завершится , а так можно
            //написать  if до цикла
            number--;
            System.out.println(number);
        }
    }



    public static void main(String[] args) {
        //   factorialOfNumber(); //Задача 1
        //    evenNumbersForUserNumber();  // Задача 2
        //    countDownForUserNumber();   // Задача 3

    }
}
