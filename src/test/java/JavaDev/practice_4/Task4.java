package JavaDev.practice_4;

import java.util.Scanner;

public class Task4 {
    public static void order(int i){
        while (i<=10){
            System.out.println(i);
            i++;
        }
    }
    public  static  void commandReader(){
        Scanner scanner = new Scanner(System.in);
        String command ="";
        while (!command.equals("exit")){
            System.out.print("Введите команду: ");
            command = scanner.nextLine();

        }
        System.out.println("Программа завершена");
    }

    public  static  int sumOfDigits(int number){
        int sum = 0;
        while (number > 0 ){
            sum = sum+number%10;
            number = number /10;
        }
        return sum;
    }

    public static void main(String[] args) {
        //order(1);
        //commandReader();
        System.out.println(sumOfDigits(123));
    }
}
