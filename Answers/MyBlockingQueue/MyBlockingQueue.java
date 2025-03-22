package MyBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

// 自定义的阻塞队列类
public class MyBlockingQueue<E> {
    private final Queue<E> queue;
    private final int capacity;

    // 构造函数，初始化队列和容量
    public MyBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    // 向队列中添加元素的方法，若队列已满则阻塞
    public synchronized void put(E element) throws InterruptedException {
        while (queue.size() == capacity) {
            // 队列已满，当前线程进入等待状态
            wait();
        }
        // 向队列中添加元素
        queue.add(element);
        // 唤醒所有等待的线程
        notifyAll();
    }

    // 从队列中取出元素的方法，若队列为空则阻塞
    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            // 队列为空，当前线程进入等待状态
            wait();
        }
        // 从队列中取出元素
        E element = queue.poll();
        // 唤醒所有等待的线程
        notifyAll();
        return element;
    }

    // 获取队列当前的大小
    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        // 创建一个容量为 5 的阻塞队列
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<Integer>(5);

        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int element = blockingQueue.take();
                    System.out.println("Consumed: " + element);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 启动生产者和消费者线程
        producer.start();
        consumer.start();

        try {
            // 等待生产者和消费者线程执行完毕
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}