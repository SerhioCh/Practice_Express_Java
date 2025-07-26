package practice_4.HomeWork;

import java.util.Scanner;

public class TasksOfFor {
    public  static  void  operationOfNumbers(){       //Задача 1
        for (int i = 1; i<=100;i++){
            if (i%3==0){
                System.out.println(i);
            }
        }
    }

    public  static  void sumOfNumberToN(){  // Задача 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int sum = 0;
        for (int i = 1;i<=number-1;i++){   // n-1  сделал, чтоб считать до 10 исключительно
            sum = sum+i;
        }
        System.out.println("Сумма числа: "+ sum);
    }
    public  static  void multiplyTableForUserNumber() {  // Задача 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int multiplyNumber = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(multiplyNumber + "*" + i + "=" + multiplyNumber * i);
        }
    }

    public  static  void simpleNumber(){                  //Задача 4
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        boolean isSimple = true;
        for (int i =2;i<=number-1;i++){
            if(number%i==0){
                isSimple = false;
                break;
            }
        }
        System.out.println("Число простое?: "+ isSimple);
    }

    public  static  void iteratorNumber(){              //Задача 5
        for (int i = 1; i <=10; i++){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        // operationOfNumbers();   // Задача 1
        // sumOfNumberToN();       // Задача 2
        // multiplyTableForUserNumber();  //Задача 3
        // simpleNumber();    // Задача 4
        // iteratorNumber();  //Задача 5

    }
}
