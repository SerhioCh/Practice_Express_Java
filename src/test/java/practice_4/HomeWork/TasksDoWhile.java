package practice_4.HomeWork;

import java.util.Scanner;

public class TasksDoWhile {
    public  static  void checkNumberForUser() {                                       //Задача 1
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Введите число: ");
            number = scanner.nextInt();
        }
        while (number<=0);


    }

    public  static  void checkPassword() {                                       //Задача 2
        Scanner scanner = new Scanner(System.in);
        String password = "serega";
        String userPass;

        do {
            System.out.println("Введите пароль");
            userPass = scanner.nextLine();
        }
        while (!userPass.equals(password));

    }

    public  static  void  ineratorNumber(){                                     //Задача 3
        int i =1;
        do {

            System.out.println(i);
            i++;
        }
        while (i<=10);
    }

    public static void endProgrammByExit(){                       // Задача 4
        Scanner scanner = new Scanner(System.in);
        String command = "exit";
        String commandUser;
        do {
            System.out.println("Введите команду для завершения работы");
            commandUser = scanner.nextLine();
        }
        while (!commandUser.equals(command));
    }

    public static void countNumberForUserNumber() {                       // Задача 5
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int count =0;
        do {
            if (number ==0){
                System.out.println("Введите число больше 0");
                break;
            }
            number = number/10;
            count++;

        }
        while (number>0);
        System.out.println("Количество цифр в веденном числе " +  count);
    }

    public static void main(String[] args) {
        // checkNumberForUser();  // Задача 1
        //   checkPassword();    // Задача 2
        // ineratorNumber();    // Задача 3
        //endProgrammByExit();  // Задача 4
        // countNumberForUserNumber(); //Задача 5
    }
}
