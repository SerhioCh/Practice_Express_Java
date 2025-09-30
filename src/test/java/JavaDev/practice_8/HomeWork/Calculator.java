package JavaDev.practice_8.HomeWork;

public class Calculator {
    public static   double devision (double num , double denum){
        if (denum==0){
            throw new ArithmeticException("На ноль делить нельзя");
        }
        return (double) num/denum ;
    }

    public static void main(String[] args) {
        try {
            System.out.println(devision(3,0));
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
