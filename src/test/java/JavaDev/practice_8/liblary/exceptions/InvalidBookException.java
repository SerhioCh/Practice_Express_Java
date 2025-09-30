package JavaDev.practice_8.liblary.exceptions;

public class InvalidBookException extends RuntimeException {
    public  InvalidBookException (String message){
        super(message);
    }
}
