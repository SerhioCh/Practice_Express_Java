package JavaDev.practice_8.HomeWork;

import JavaDev.practice_8.HomeWork.exceptions.InvalidAge;

public class TaskOfAge {
    public static void validationAge (int age) throws  InvalidAge{
        if (age< 0 || age>150){
            throw new InvalidAge("Введен неверный возраст");
        }
        System.out.println("Возраст: "+ age);
    }

    public static void main(String[] args) {
        try {
            validationAge(-1);
        }
        catch (InvalidAge e){
            System.out.println(e.getMessage());
        }
    }
}
