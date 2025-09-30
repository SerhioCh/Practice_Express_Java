package JavaDev.practice_3;

public class MathConstants {
    static final double PI = 3.14159;
    static final double E = 2.71828;

    static  double calculateCircleArea (double r){
        return PI*(r*r);
    }
    static double calculateCircumference(double r){
        return 2*PI * r;
    }

    public static void main(String[] args) {
        System.out.println(MathConstants.calculateCircumference(3));
        System.out.println(MathConstants.calculateCircleArea(2));

    }

}
