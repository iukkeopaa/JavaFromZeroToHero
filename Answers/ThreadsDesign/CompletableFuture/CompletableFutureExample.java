package ThreadsDesign.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个 CompletableFuture 并执行异步任务
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1 + 2;
        });

        // 处理任务结果
        CompletableFuture<String> resultFuture = future.thenApply(result -> "任务结果: " + result);

        // 获取最终结果
        String result = resultFuture.get();
        System.out.println(result);
    }
}