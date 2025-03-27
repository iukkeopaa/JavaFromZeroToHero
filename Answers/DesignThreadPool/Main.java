package DesignThreadPool;

import java.util.LinkedList;
import java.util.List;

// 自定义线程池类
class SimpleThreadPool {
    // 任务队列，用于存储待执行的任务
    private final LinkedList<Runnable> taskQueue;
    // 工作线程列表，存储线程池中的工作线程
    private final List<WorkerThread> workerThreads;
    // 线程池是否关闭的标志
    private boolean isShutdown = false;

    // 构造函数，初始化线程池
    public SimpleThreadPool(int poolSize) {
        taskQueue = new LinkedList<>();
        workerThreads = new LinkedList<>();
        // 创建指定数量的工作线程并启动
        for (int i = 0; i < poolSize; i++) {
            WorkerThread worker = new WorkerThread();
            workerThreads.add(worker);
            worker.start();
        }
    }

    // 向线程池提交任务的方法
    public synchronized void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("线程池已关闭，无法提交任务。");
        }
        // 将任务添加到任务队列
        taskQueue.add(task);
        // 唤醒一个等待的工作线程
        notify();
    }

    // 关闭线程池的方法
    public synchronized void shutdown() {
        isShutdown = true;
        // 唤醒所有等待的工作线程
        notifyAll();
        for (WorkerThread worker : workerThreads) {
            try {
                // 等待工作线程执行完毕
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 工作线程类，继承自 Thread 类
    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (SimpleThreadPool.this) {
                    // 当任务队列为空且线程池未关闭时，工作线程进入等待状态
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            SimpleThreadPool.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 如果线程池已关闭且任务队列为空，工作线程退出循环
                    if (isShutdown && taskQueue.isEmpty()) {
                        break;
                    }
                    // 从任务队列中取出一个任务
                    task = taskQueue.poll();
                }
                if (task != null) {
                    try {
                        // 执行任务
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

// 主类，用于测试线程池
public class Main {
    public static void main(String[] args) {
        // 创建一个包含 3 个工作线程的线程池
        SimpleThreadPool threadPool = new SimpleThreadPool(3);

        // 提交 5 个任务到线程池
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("正在执行任务: " + taskId);
                try {
                    // 模拟任务执行耗时
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务 " + taskId + " 执行完毕。");
            });
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}    