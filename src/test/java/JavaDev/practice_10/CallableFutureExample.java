package JavaDev.practice_10;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable <Integer> dnkResult = () -> {
            System.out.println("Сложное вычисление ДНК");
            Thread.sleep(10000);
            int randomDnkResult = new Random().nextInt();
            return  randomDnkResult;
        };
        Future <Integer> future = executorService.submit(dnkResult);
        System.out.println("Результат DNK: "+ future.get());
        executorService.shutdown();
    }
}
