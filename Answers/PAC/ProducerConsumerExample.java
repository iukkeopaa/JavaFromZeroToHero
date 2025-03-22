package PAC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

    // 共享缓冲区，用于存储文件内容
    //使用BlockingQueue作为共享缓冲区，容量为10。
    //BlockingQueue是线程安全的，支持阻塞操作（如put和take）。
    private static final BlockingQueue<String> buffer = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        // 创建生产者线程
        Thread producerThread = new Thread(new Producer("input.txt"));
        producerThread.start();

        // 创建三个消费者线程
        Thread consumerThread1 = new Thread(new Consumer("Consumer 1"));
        Thread consumerThread2 = new Thread(new Consumer("Consumer 2"));
        Thread consumerThread3 = new Thread(new Consumer("Consumer 3"));

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }

    // 生产者类
    static class Producer implements Runnable {
        private final String filePath;

        public Producer(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // 将文件内容放入缓冲区
                    buffer.put(line);
                    System.out.println("Producer produced: " + line);
                }
                // 发送结束信号
                buffer.put("EOF"); // EOF 表示文件结束
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者类
    static class Consumer implements Runnable {
        private final String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // 从缓冲区中获取内容
                    String line = buffer.take();
                    if (line.equals("EOF")) {
                        // 如果读到结束信号，重新放入缓冲区以便其他消费者也能读到
                        buffer.put("EOF");
                        break;
                    }
                    // 输出内容
                    System.out.println(name + " consumed: " + line);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}