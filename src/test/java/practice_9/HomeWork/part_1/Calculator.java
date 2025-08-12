package practice_9.HomeWork.part_1;

public class Calculator {
    public static void main(String[] args) {

        MathOperations sumOfNumbers = (x, y) -> x+y;
        MathOperations subtractionOfNumbers = (x, y) -> x-y;
        MathOperations multiplyOfNumbers = (x, y) -> x*y;
        MathOperations devideOfNumbers = (x, y) -> (double) x/y;

//        System.out.println(sumOfNumbers.apply(3,4));
//        System.out.println(subtractionOfNumbers.apply(10,5));
//        System.out.println(multiplyOfNumbers.apply(3,4));
//        System.out.println(devideOfNumbers.apply(10,2));     Задача 1

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        };

        r1.run();   // Задача 2
    }
}
