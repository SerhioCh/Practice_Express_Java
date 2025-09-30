package JavaDev.practice_4;

import java.util.Scanner;

public class TaskIfElse {

    public static void checkNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        if (number>0){
            System.out.println("Число положительное");
        }
        if (number<0){
            System.out.println("Число отрицательное");

        }
        if (number==0){
            System.out.println("Число равно нулю");

        }
    }

    public static void maxValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();
        int max = b;
        if (a>b){
            max = a;
        }
        System.out.println("Наибольшее число: " + max);
    }

    public static  void describeNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите оценку от 1 до 5");
        int number = scanner.nextInt();
        switch (number){
            case 5:
                System.out.println("Отлично");
                break;
            case 4:
                System.out.println("Хорошо");
                break;
            case 3:
                System.out.println("Удовлетворительно");
                break;
            case 2:
            case 1:
                System.out.println("Неудовлетворительно");
                break;
            default:
                System.out.println("Оценка неверная");
        }
    }

    public  static  void  parityNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        if (number%2==0){
            System.out.println("Четное");
        }
        else {
            System.out.println("Нечетное");
        }
    }

    public  static void  valueDiscount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        int discount;
        if (age<18){
            discount = 25;
            System.out.println("Cкидка" + discount+"%");
        }
        else if (age>=65){
            discount = 30;
            System.out.println("Cкидка" + discount+"%");
        }
        else {
            discount = 0;
            System.out.println(discount + "%" + " Cкидки нет");
        }
    }
        public  static  void  calculator (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        System.out.println("Введите операцию");
        char c = scanner.next().charAt(0);
        switch (c){
            case '+':
                int summa = a+b;
                System.out.println(summa);
                break;
            case '-':
                int vichitanie = a - b;
                System.out.println(vichitanie);
                break;
        }
        }
        public static   void simpleNumber(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число");
        int number = scanner.nextInt();
            boolean isPrime = true;
            for (int i =2 ;i<=number-1;i++){
                if (number%i == 0){
                    isPrime = false;
                    break;
                }
            }
            System.out.println("Число простое? : " + isPrime);
        }

        public  static  int factorialNumber(int number){
        int result =1;
        int i = 1;
        while(i<=number) {
         result = result*i;
         i++;
        }
        return result;
      }

      // от 1 до моего числа i=1 i<=n;i++
      public  static  int  numbers (int number){
        int i =1;
        while (i<=number-1){
            if (i%2==0){
                System.out.println(i);
            }
            i++;
        }
        return i;
      }
    public  static  int  numbersDec (int number){
        int i =1;
        while (i<number){
            System.out.println(number);
            number--;
        }
        return number;
    }
    public static void  numberDoWhile(){
        int i =1;
        do {
            System.out.println(i);
            i++;
        }
        while (i<=10);
    }
    public  static void  exitConsole(){
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Введите комманду");
            command = scanner.nextLine();
        }
        while (!command.equals("exit"));
    }

    public  static void    numberOfNumber(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите число");
        int number = scanner.nextInt();
        do {
            if (number==0){
                System.out.println("Введите число отличное от 0");
                break;
            }
            number = number/10;
            count++;

        }
        while (number!=0);

        System.out.println(count);
    }

    public  static void plusNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;


        do {
            System.out.println("Ввведите положительное число: ");
        number = scanner.nextInt();
        }
        while (number<=0);
    }

    public  static  void randomNumbers(){
        Scanner scanner = new Scanner(System.in);
        int a ;
        int b ;
        int summ = 0;
        while (true){
            System.out.println("Введите превое число");
            a =scanner.nextInt();
            if (a < 0) break;
            System.out.println("Введите второе  число");
            b = scanner.nextInt();
            if (b < 0) break;
            summ = a+b;
            System.out.println("Сумма: чисел:"+summ);
        }

    }




    public static void main(String[] args) {
        //checkNumber();
        //maxValue();
        //describeNumber();
        //parityNumber();
        //valueDiscount();
        //calculator();
        //simpleNumber();
        // System.out.println(numbers(24));
        // System.out.println(numbersDec(10));
        //numberDoWhile();
        //exitConsole();
       // numberOfNumber();
        //plusNumber();
        randomNumbers();
    }
}
