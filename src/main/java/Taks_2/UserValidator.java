package Taks_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator extends ActiveValidator{
    List<User>  users = new ArrayList<>();

    public  List<User> getUsers(){
        return users;
    }
    public void validationForName (User user) throws InvalidUserException {
        char firstChar = user.getName().charAt(0);
        if (isValidationEnabled()) {
            if (user.getName().charAt(0) == Character.toUpperCase(firstChar) && user.getName() != null && !Objects.equals(user.getName(), " ")) {
                users.add(user);
                System.out.println("Валидация по имени  пройдена, пользователь добавлен");
            } else {
                throw new InvalidUserException("Имя начинается с маленькой буквы или не заполнено");
            }
        }
        else {
            users.add(user);
            System.out.println("Валидация не активна");
        }
    }

    public  void validationForAge(User user) throws InvalidUserException {
        if (isValidationEnabled()) {
            if (user.getAge() >= 18 && user.getAge() <= 100) {
                users.add(user);
                System.out.println("Валидация пройдена по возрасту пройдена, пользователь добавлен");
            } else {
                throw new InvalidUserException("Возраст не удовлетворяет критериям");
            }
        }
        else   {
            users.add(user);
            System.out.println("Валидация не активна");
        }
    }


    public  void validationForEmail (User user) throws  InvalidUserException{
         String email = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
         Pattern pattern = Pattern.compile(email);
         Matcher matcher = pattern.matcher(user.getEmail());
        if (isValidationEnabled()) {
            if (matcher.matches()) {
                users.add(user);
                System.out.println("Валидация по имейлу пройдена пользователь добавлен");
            } else {
                throw new InvalidUserException("Email введен не верно");
            }
        }
        else {
            users.add(user);
            System.out.println("Валидация не активна");
        }
    }
}
