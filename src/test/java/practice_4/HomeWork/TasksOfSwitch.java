package practice_4.HomeWork;

import java.util.Scanner;

public class TasksOfSwitch {
    public  static void dayOfWeek(){                        //Задача 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число дня недели");
        int day = scanner.nextInt();
        switch (day){
                        case 1:
                        System.out.println("Понедельник");
                        break;
                        case 2:
                        System.out.println("Вторник");
                        break;
                        case 3:
                        System.out.println("Среда");
                        break;
                        case 4:
                        System.out.println("Четверг");
                        break;
                        case 5:
                        System.out.println("Пятница");
                        break;
                        case 6:
                        System.out.println("Суббота");
                        break;
                        case 7:
                        System.out.println("Воскресение");
                        break;
                        default:
                        System.out.println("Неверное число дня недели");
        }

    }

    public  static  void  costTikets(){                                             //Задача 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число дня недели");
        int day = scanner.nextInt();
        int cost;
        switch (day){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                cost = 300;
                System.out.println("Стоимость билета: " + cost);
               break;
            case 6:
            case 7:
                cost = 450;
                System.out.println("Стоимость билета: " + cost);
               break;
            default:
                System.out.println("Неверное число дня недели");
        }
    }
    public  static  void  calculationRatings(){                             // Задача 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 0 до 100");
        int number = scanner.nextInt();
        if (number >=90 && number <=100){     // Использовал if т.к по условиям не запрещено и так быстрее
            System.out.println("Оценка: А");
        }
        else if (number >=80 && number <=89){
            System.out.println("Оценка: B");
        }
        else if (number >=70 && number <=79){
            System.out.println("Оценка: C");
        }
        else if (number >=60 && number <=69){
            System.out.println("Оценка: D");
        }
        else if (number >=0 && number <=59){
            System.out.println("Оценка: F");
        }
        else {
            System.out.println("Введена неправильная оценка");
        }
    }
    public  static  void textCommands(){                 //Задача 4
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду");
        String command = scanner.nextLine();
        switch (command){
                case "start":
                System.out.println("Система запущена");
                break;
                case "stop":
                System.out.println("Система остановлена");
                break;
                case "restart":
                System.out.println("Система перезапущена");
                break;
                case "status":
                System.out.println("Статус системы");
                break;
                default:
                    System.out.println("Неверная команда");
        }
    }

    public  static void calculator(){                                       // Задача 5
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите первое число");
        int b = scanner.nextInt();
        System.out.println("Введите оператор +, -, *, / ");
        char c  = scanner.next().charAt(0);
        switch (c) {
                case '+':
                int summ = a+b;
                System.out.println("Сумма: "+ summ);
                break;
                case '-':
                int substract = a-b;
                System.out.println("Вычитание: "+ substract);
                break;
                case '*':
                int multiply = a*b;
                System.out.println("Умножение: "+ multiply);
                break;
                case '/':
                int division = a/b;
                System.out.println("Деление: "+ division);
                break;
                default:
                    System.out.println("Введен неверный оператор, разрешенные операторы +, -, *, / ");
        }

    }



    public static void main(String[] args) {
        // dayOfWeek();                     //  Задача 1
        //  costTikets();                   //  Задача 2
        //  calculationRatings();           //  Задача 3
        //textCommands();                   //  Задача 4
        // calculator();                    //  Задача 5
    }
}
