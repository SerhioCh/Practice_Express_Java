package JavaDev.practice_8.HomeWork.exceptions;

public class InvalidEmail extends RuntimeException {
    public InvalidEmail(String message){
        super(message);
    }
}
