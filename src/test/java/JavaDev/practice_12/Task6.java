package JavaDev.practice_12;

public class Task6 {
    public static void main(String[] args) {
        countdown(5);
    }
    public static int  countdown(int n) {
        if(n<1){
            return 0;
        }
        System.out.println(n);
        countdown(n - 1);
        return n;
    }
}
