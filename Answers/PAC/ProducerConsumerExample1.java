package PAC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final String filePath;

    public Producer(BlockingQueue<String> queue, String filePath) {
        this.queue = queue;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                // 将读取的行放入队列
                queue.put(line);
            }
            // 发送结束信号
            for (int i = 0; i < 3; i++) {
                queue.put(null);
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// 消费者类
class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    private final int id;

    public Consumer(BlockingQueue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            String line;
            // 从队列中取出内容
            while ((line = queue.take()) != null) {
                // 输出内容
                System.out.println("消费者 " + id + " 消费: " + line);
            }
            System.out.println("消费者 " + id + " 完成工作。");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample1 {
    public static void main(String[] args) {
        // 创建共享缓冲区
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // 定义文件路径
        String filePath = "example.txt";

        // 创建生产者线程
        Thread producerThread = new Thread(new Producer(queue, filePath));
        // 创建三个消费者线程
        Thread[] consumerThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumerThreads[i] = new Thread(new Consumer(queue, i + 1));
        }

        // 启动生产者线程
        producerThread.start();
        // 启动三个消费者线程
        for (Thread consumerThread : consumerThreads) {
            consumerThread.start();
        }

        try {
            // 等待生产者线程执行完毕
            producerThread.join();
            // 等待三个消费者线程执行完毕
            for (Thread consumerThread : consumerThreads) {
                consumerThread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("所有任务完成。");
    }
}