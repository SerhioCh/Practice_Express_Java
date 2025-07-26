package practice_4.HomeWork;

import java.util.Scanner;

public class IfElseTask {
    public static void checkNumber(){                                       //Задача 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        if(number>0){
            System.out.println("Число положительное");
        }
        if (number<0){
            System.out.println("Число отрицательное");
        }
        if (number==0){
            System.out.println("Число равно нулю");
        }

    }

    public  static  void numberMax(){                                       // Задача 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите первое число");
        int b = scanner.nextInt();
        int  numbersMax = a;
        if (b>a){
            numbersMax = b;
        }
        System.out.println("Наибольшее число: " + numbersMax);
    }

    public  static  void outputOfRatings(){                                     //Задача 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите оценку от 1 до 5");
        int rating = scanner.nextInt();
        if (rating==5){
            System.out.println("Отлично");
        }
        else if (rating==4){
            System.out.println("Хорошо");
        }
        else if (rating==3){
            System.out.println("Удовлетворительно");
        }
        else if (rating==2|| rating == 1){
            System.out.println("Неудовлетворительно");
        }
        else {
            System.out.println("Неверная оценка");
        }

    }
public  static  void checkParity (){                                        //Задача 4
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число");
    int number = scanner.nextInt();
    if (number%2==0){
        System.out.println("Число является четным");
    }
    else {
        System.out.println("Число нечетное");
    }
}
public  static  void applyingDiscount(){                                    // Задача 5
    Scanner scanner = new Scanner(System.in);
    System.out.println("Укажите возраст");
    int age = scanner.nextInt();
    int discount;
    if (age<18){
        discount = 25;
        System.out.println("Cкидка: "+discount+" %");
    }
    else if (age>=65){
        discount = 30;
        System.out.println("Cкидка: "+ discount+" %");
    }
    else {
        discount = 0;
        System.out.println("Cкидка не применена");
    }
}

public  static  void ratingsOfTest(){                                       //Задача 6
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите результат теста от 0 до 100");
    int rating = scanner.nextInt();
    if(rating>=90 && rating <=100){
        System.out.println("Оценка: Отлично");
    }
   else if(rating >=75 && rating <=89){
        System.out.println("Оценка: Хорошо");
    }
   else if(rating >=60 && rating <=74){
        System.out.println("Оценка: Удовлетворительно");
    }
   else if(rating >=0 && rating <=59){
        System.out.println("Оценка: Неудовлетворительно");
    }
   else {
        System.out.println("Оценка введена неверно");
    }
}



    public static void main(String[] args) {
        //   checkNumber();         // Задача 1
        //   numberMax();           // Задача 2
        //   outputOfRatings();     // Задача 3
        //   checkParity();         // Задача 4
        // applyingDiscount();      // Задача 5
        // ratingsOfTest();         // Задача 6
    }
}
