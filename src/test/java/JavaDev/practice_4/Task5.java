package JavaDev.practice_4;

import java.util.Random;
import java.util.Scanner;

public class Task5 {
    public static void findNumber(int bound) {
        Scanner scanner = new Scanner(System.in);
        int  random = new Random().nextInt(5);
        int number;
        do {
            System.out.print("Угадайте число: ");
             number = scanner.nextInt();
        }
        while (number!= random);
        System.out.println("Верно");
    }

    public  static  void findMin(){
        Scanner scanner = new Scanner(System.in);
        int number;
        int min = 2147483647;
        do {
            System.out.print("Угадайте число: ");
            number = scanner.nextInt();
            if (number< min && number>= 0) min = number;
        } while (number>=0);
        System.out.println("Минимальное число"+ min);

    }

    public  static void cheeckCredetials(){
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;

        do {
            System.out.println("Введите логин");
            login = scanner.nextLine();
            System.out.println("Введите пароль");
            password = scanner.nextLine();
        }while (!login.equals("admin") || !password.equals("123"));
        System.out.println("Доступ разрешен");
    }



    public static void main(String[] args) {
//findNumber(5);
      // findMin();
        cheeckCredetials();
    }

}
