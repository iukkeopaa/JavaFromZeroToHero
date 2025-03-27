package DesignCounter;

import java.util.concurrent.atomic.AtomicInteger;

class SafeCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    // 增加计数
    public void increment() {
        count.incrementAndGet();
    }

    // 减少计数
    public void decrement() {
        count.decrementAndGet();
    }

    // 获取当前计数值
    public int getCount() {
        return count.get();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        int threadCount = 100;
        Thread[] threads = new Thread[threadCount];

        // 创建并启动线程
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread thread : threads) {
            thread.join();
        }

        // 输出最终计数值
        System.out.println("最终计数值: " + counter.getCount());
    }
}

//class SafeCounter {
//    private int count = 0;
//
//    // 增加计数的同步方法
//    public synchronized void increment() {
//        count++;
//    }
//
//    // 减少计数的同步方法
//    public synchronized void decrement() {
//        count--;
//    }
//
//    // 获取当前计数值的同步方法
//    public synchronized int getCount() {
//        return count;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        SafeCounter counter = new SafeCounter();
//        int threadCount = 100;
//        Thread[] threads = new Thread[threadCount];
//
//        // 创建并启动线程
//        for (int i = 0; i < threadCount; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    counter.increment();
//                }
//            });
//            threads[i].start();
//        }
//
//        // 等待所有线程执行完毕
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        // 输出最终计数值
//        System.out.println("最终计数值: " + counter.getCount());
//    }
//}