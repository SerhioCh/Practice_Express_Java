package JavaDev.practice_8.HomeWork;

import JavaDev.practice_8.HomeWork.exceptions.InvalidEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOfEmail {
    public static   void validationEmail (String email){
        String regex = "^[\\w]+@+[\\w]+\\.[a-zA-z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            System.out.println("Email: "+ email +" корректный");
        }
        else {
            throw  new InvalidEmail("Email: "+ email+ " введен некорректно");
        }
    }

    public static void main(String[] args) {
        try {
            validationEmail("s.ere@ma.ru");
        }
        catch (InvalidEmail e){
            System.out.println(e.getMessage());
        }
    }

}
