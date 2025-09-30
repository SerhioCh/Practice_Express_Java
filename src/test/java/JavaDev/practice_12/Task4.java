package JavaDev.practice_12;

public class Task4 {
    public static void main(String[] args) {
        try {
            System.out.println(isPalindrome(null));
        }
        catch (NullPointerException e){
            System.err.println(e.getMessage());
        }

    }
    public static boolean isPalindrome(String str) {
        if(str==null){
            throw new NullPointerException("Введите слово");
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
