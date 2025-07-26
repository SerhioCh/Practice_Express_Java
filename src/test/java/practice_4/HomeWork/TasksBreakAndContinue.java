package practice_4.HomeWork;

import java.util.Scanner;

public class TasksBreakAndContinue {
    public static void summOfStructNumber(){   // Задача 1
        Scanner scanner = new Scanner(System.in);
                int a ;
                int b;
                int sum;
            while (true){
                System.out.println("Введите первое число");
                 a = scanner.nextInt();
                if (a<=0) break;
                System.out.println("Введите второе число");
                b = scanner.nextInt();
                if (b<=0) break;
                sum = a+b;
                System.out.println("Сумма чисел "+ sum);
            }

    }

    public  static  void  skipNumberDevisibleByThree(){               // Задача 2
        for (int i=1;i<=20;i++){
            if (i%3==0){
                continue;
            }
            System.out.println(i);
        }
    }


    public  static  void   outputPositiveNumbers(){                 // Задача 3
        Scanner scanner = new Scanner(System.in);
        int a;
        while (true){
            System.out.println("Введите число: ");
            a= scanner.nextInt();
            if (a<0) {
                System.out.println("Число отрицательное , пропускаем");
                continue;
            }
            if (a==0){
                System.out.println("Выход их программы при 0");
                break;
            }

            System.out.println("Вы ввели положительное число: "+ a);

        }

    }

    public  static  void  stopProgramm(){                                           // Задача 4
        Scanner scanner = new Scanner(System.in);
        String command = "stop";
        String userCommand="";
        while (true){
            System.out.println("Введите команду для завершения");
            userCommand = scanner.nextLine();
            if (userCommand.equals(command)){
                break;
            }
        }
    }


    public static void main(String[] args) {
      //  summOfStructNumber();   // Задача 1
      //  skipNumberDevisibleByThree(); // Задача 2
       // outputPositiveNumbers();      // Задача 3
        //  stopProgramm();  // Задача 4
    }

}
