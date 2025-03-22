package PAC.LinedBlockQueueImpl;

import java.util.concurrent.LinkedBlockingQueue;

// 任务类
class Task {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}

// 生产者类
class Producer1 implements Runnable {
    private LinkedBlockingQueue<Task> workQueue;
    private int taskCount;

    public Producer1(LinkedBlockingQueue<Task> workQueue, int taskCount) {
        this.workQueue = workQueue;
        this.taskCount = taskCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < taskCount; i++) {
                Task task = new Task(i);
                workQueue.put(task);
                System.out.println("Produced: " + task);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// 消费者类
class Consumer1 implements Runnable {
    private LinkedBlockingQueue<Task> workQueue;

    public Consumer1(LinkedBlockingQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = workQueue.take();
                System.out.println("Consumed: " + task);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class WorkQueueExample {
    public static void main(String[] args) {
        // 创建一个容量为 10 的工作队列
        LinkedBlockingQueue<Task> workQueue = new LinkedBlockingQueue<>(10);

        // 创建生产者线程
        Thread producerThread = new Thread(new Producer1(workQueue, 5));
        // 创建消费者线程
        Thread consumerThread = new Thread(new Consumer1(workQueue));

        // 启动生产者和消费者线程
        producerThread.start();
        consumerThread.start();
    }
}