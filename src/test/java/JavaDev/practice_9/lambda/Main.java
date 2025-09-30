package JavaDev.practice_9.lambda;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello word");
            }
        };

        r1.run();


        Runnable r2 = () -> {
            System.out.println("Привет мир");
        };
        r2.run();
    }
}
