package CleanCode.practice_1;

public class Task1 {
    public static int sumOfArguments(int... numbers) {
       int result =0;
        for (int i: numbers){
          result+=i;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(sumOfArguments(1,2,3,4));
        System.out.println(sumOfArguments(3,4));
    }
}
