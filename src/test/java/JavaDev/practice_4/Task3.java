package JavaDev.practice_4;

public class Task3 {
    public static void multiplyTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + "*" + i + "=" + number * i);
        }
    }

    public static int summOfAllNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public  static  boolean checkNumberIsSimple(int number) {
        boolean isSimple = true;
        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                isSimple = false;
                break;
            }
        }
        return  isSimple;
    }

    public static void main(String[] args) {
        //multiplyTable(5);
       // System.out.println(summOfAllNumber(20));
        System.out.println(checkNumberIsSimple(7));
    }

}
