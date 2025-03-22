package HowToCreateThreads.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task is running in thread pool.");
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyTask myTask = new MyTask();
        executorService.submit(myTask);
        executorService.shutdown();
    }
}