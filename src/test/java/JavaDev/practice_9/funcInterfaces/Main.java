package JavaDev.practice_9.funcInterfaces;

public class Main {

    public static void main(String[] args) {
        MathOperations add = (x,y) ->  x+y;
        MathOperations substract = (x,y) ->  x-y;
        MathOperations multiply = (x,y) ->  x*y;
        MathOperations devide = (x,y) ->  x/y;

        Checker isPositive = n -> n>0;
        isPositive.printIfValid(5);
        isPositive.printIfValid(-1);

        Runnable r  =  new Runnable() {
            @Override
            public void run() {
                System.out.println("Ghv");
            }

        };

        r.run();

//        System.out.println(add.apply(2,3));
//        System.out.println(substract.apply(10,7));
//        System.out.println(multiply.apply(8,3));
//        System.out.println(devide.apply(15,5));
    }

}
