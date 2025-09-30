package JavaDev.practice_12;

public class Task8 {
    public static void main(String[] args) {
        double a = 0.1 * 3;
        double rounded = Math.round(a*10)/10.0;
        double b = 0.3;
        if (rounded == b) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
