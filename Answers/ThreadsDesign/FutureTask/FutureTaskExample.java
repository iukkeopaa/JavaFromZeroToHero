
package ThreadsDesign.FutureTask;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个 Callable 任务
        Callable<Integer> callable = () -> {
            Thread.sleep(2000);
            return 1 + 2;
        };

        // 创建 FutureTask 并传入 Callable 任务
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 创建线程并启动 FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();

        // 获取任务结果
        Integer result = futureTask.get();
        System.out.println("任务结果: " + result);
    }
}