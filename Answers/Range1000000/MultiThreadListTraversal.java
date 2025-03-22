package Range1000000;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadListTraversal {
    public static void main(String[] args) throws InterruptedException {
        // 初始化 100 万条数据
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(i);
        }

        // 线程数量
        int threadCount = 4;
        // 每个线程处理的数据量
        int chunkSize = data.size() / threadCount;
        System.out.println(chunkSize);

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        // 分割数据并提交任务
        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunkSize;
            // 注意最后一个线程需要处理剩余的所有数据
            final int end = (i == threadCount - 1) ? data.size() : (i + 1) * chunkSize;

            executorService.submit(() -> {
                for (int j = start; j < end; j++) {
                    // 模拟处理数据
                    System.out.println(Thread.currentThread().getName() + " processing: " + data.get(j));
                }
            });
        }

        // 关闭线程池
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}