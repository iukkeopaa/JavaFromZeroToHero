package Range1000000;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadedDataTraversal2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 模拟 100 万条数据
        List<Integer> data = generateData(1_000_000);

        // 线程池大小
        int threadPoolSize = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

        // 每个线程处理的数据片段大小
        int chunkSize = data.size() / threadPoolSize;

        // 用于存储每个线程的结果
        List<Future<Long>> futures = new ArrayList<>();

        // 提交任务
        for (int i = 0; i < threadPoolSize; i++) {
            int start = i * chunkSize;
            int end = (i == threadPoolSize - 1) ? data.size() : start + chunkSize;
            futures.add(executor.submit(new DataProcessor(data, start, end)));
        }

        // 汇总结果
        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        // 关闭线程池
        executor.shutdown();

        // 输出结果
        System.out.println("Total sum: " + totalSum);
    }

    // 生成模拟数据
    private static List<Integer> generateData(int size) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(i);
        }
        return data;
    }

    // 数据处理任务
    static class DataProcessor implements Callable<Long> {
        private final List<Integer> data;
        private final int start;
        private final int end;

        public DataProcessor(List<Integer> data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += data.get(i);
            }
            System.out.println(Thread.currentThread().getName() + " processed from " + start + " to " + end + ", sum: " + sum);
            return sum;
        }
    }
}