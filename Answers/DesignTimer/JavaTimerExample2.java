package DesignTimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JavaTimerExample2 {
    public static void main(String[] args) {
        // 创建一个单线程的 ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // 定义任务逻辑
        Runnable task = () -> System.out.println("定时任务执行，当前时间：" + System.currentTimeMillis());

        // 安排任务在延迟 1000 毫秒后开始执行，之后每隔 2000 毫秒执行一次
        executor.scheduleAtFixedRate(task, 1000, 2000, TimeUnit.MILLISECONDS);
    }
}