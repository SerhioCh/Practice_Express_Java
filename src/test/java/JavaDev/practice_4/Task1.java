package JavaDev.practice_4;

public class Task1 {

public static String  checkParityNumber (int number){
    String parity = "Число не четное";
    if (number%2==0){
    parity = "Четное";
    }
    return parity;
}
public static String checkAge (int age){
    String ageDescription = "";
    if(age<18){
ageDescription = "Несовершеннолетний";
    }
    if (age >=18 && age <=60){
        ageDescription = "Взрослый";
    }
    return  ageDescription;
}

public static int checkMaxNumber (int a , int b , int c){
    int maxAB = b;
    if (a>b){
        maxAB = a;
    }
    int max = c;
    if (maxAB>c){
        max = maxAB;
    }
    return max;
}

    public static void main(String[] args) {
        System.out.println(checkParityNumber(2));
        System.out.println(checkAge(18));
        System.out.println(checkMaxNumber(101,22,64));
    }
}
