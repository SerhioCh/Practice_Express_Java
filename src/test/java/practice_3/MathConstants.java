package practice_3;

public class MathConstants {
    final double PI = 3.14159;
    final double E = 2.71828;

    static  double calculateCircleArea (double r){
        MathConstants m1 = new MathConstants();
        return m1.PI*(r*r);
    }
    static double calculateCircumference(double r){
        MathConstants m1 = new MathConstants();
        return 2* m1.PI * r;
    }

    public static void main(String[] args) {
        System.out.println(MathConstants.calculateCircumference(3));
        System.out.println(MathConstants.calculateCircleArea(2));

    }

}
