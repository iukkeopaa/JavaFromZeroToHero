package Question.Q6;

import java.util.concurrent.CountDownLatch;

public class ThreadExecutionOrderDemo {
    private static CountDownLatch t1ToT2Latch = new CountDownLatch(1);
    private static CountDownLatch t2ToT3Latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            executeTask("T1", () -> t1ToT2Latch.countDown());
        }, "T1");

        Thread t2 = new Thread(() -> {
            try {
                t1ToT2Latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            executeTask("T2", () -> t2ToT3Latch.countDown());
        }, "T2");

        Thread t3 = new Thread(() -> {
            try {
                t2ToT3Latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            executeTask("T3", () -> {});
        }, "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    private static void executeTask(String threadName, Runnable afterTask) {
        long startTime = System.currentTimeMillis();
        System.out.println(threadName + " 开始执行!");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(threadName + " 被中断");
            return;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(threadName + " 执行时间:" + (endTime - startTime) + "ms");
        System.out.println(threadName + " 执行完毕!");
        System.out.println("------------------------------------------------");
        afterTask.run();
    }
}