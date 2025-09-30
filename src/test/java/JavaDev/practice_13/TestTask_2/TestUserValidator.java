package JavaDev.practice_13.TestTask_2;

import Taks_2.InvalidUserException;
import Taks_2.User;
import Taks_2.UserValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserValidator {



    @Test
    public void checkSuccessNameValidator() throws InvalidUserException {
        UserValidator validator = new UserValidator();
         validator.setValidationEnabled(true);
        validator.validationForName(new User("Serega", 16, "ser@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
    }

    @Test
    public void checkUnSuccessNameValidatorSmallLetter() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception =  assertThrows(InvalidUserException.class,()->{
            validator.validationForName(new User("serega", 16, "ser@mail.ru"));
        });
        assertEquals("Имя начинается с маленькой буквы или не заполнено",exception.getMessage());


    }
    @Test
    public void checkUnSuccessNameValidatorEmpty() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception =  assertThrows(InvalidUserException.class,()->{
            validator.validationForName(new User(" ", 16, "ser@mail.ru"));
        });
        assertEquals("Имя начинается с маленькой буквы или не заполнено",exception.getMessage());
    }

    @Test
    public void checkOffValidatorName() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(false);
        validator.validationForName(new User("serega", 16, "ser@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
        assertEquals(1,validator.getUsers().size());
        assertEquals("serega",validator.getUsers().get(0).getName());

    }


    @Test
    public void checkSuccessAgeValidator() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        validator.validationForAge(new User("Serega", 18, "ser@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
    }


    @Test
    public void checkUnSuccessAgeValidatorLess() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception = assertThrows(InvalidUserException.class, () -> {
            validator.validationForAge(new User("serega", 16, "ser@mail.ru"));
        });
        assertEquals("Возраст не удовлетворяет критериям", exception.getMessage());
    }

    @Test
    public void checkUnSuccessAgeValidatorMore() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception = assertThrows(InvalidUserException.class, () -> {
            validator.validationForAge(new User("serega", 101, "ser@mail.ru"));
        });
        assertEquals("Возраст не удовлетворяет критериям", exception.getMessage());
    }

    @Test
    public void checkOffValidatorAge() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(false);
        validator.validationForAge(new User("serega", 16, "ser@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
        assertEquals(1,validator.getUsers().size());
        assertEquals(16,validator.getUsers().get(0).getAge());

    }

    @Test
    public void checkSuccessEmailValidator() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        validator.validationForEmail(new User("Serega", 18, "ser@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
    }


    @Test
    public void checkUnSuccessEmailValidator() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception = assertThrows(InvalidUserException.class, () -> {
            validator.validationForEmail(new User("serega", 16, "@mail.ru"));
        });
        assertEquals("Email введен не верно", exception.getMessage());
    }

    @Test
    public void checkUnSuccessEmailValidatorEmpty() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);
        Exception exception = assertThrows(InvalidUserException.class, () -> {
            validator.validationForEmail(new User("serega", 101, " "));
        });
        assertEquals("Email введен не верно", exception.getMessage());
    }

    @Test
    public void checkOffValidatorEmail() throws InvalidUserException {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(false);
        validator.validationForEmail(new User("serega", 16, "@mail.ru"));
        assertFalse(validator.getUsers().isEmpty());
        assertEquals(1,validator.getUsers().size());
        assertEquals("@mail.ru",validator.getUsers().get(0).getEmail());

    }
}