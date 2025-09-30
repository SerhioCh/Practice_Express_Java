package JavaDev.practice_9.funcInterfaces;

public interface Checker {

    boolean check(int number);

    default void printIfValid(int number){
        if (check(number)) {
            System.out.println(number);
        }
    }
}
