package AlternatePrinting;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrinting {
    private static final int MAX_NUMBER = 75;
    private static int currentNumber = 1;
    private static int currentThread = 1;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    private static final Condition condition3 = lock.newCondition();

    static class Printer implements Runnable {
        private final int threadId;
        private final Condition currentCondition;
        private final Condition nextCondition;

        public Printer(int threadId, Condition currentCondition, Condition nextCondition) {
            this.threadId = threadId;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    // 检查是否轮到当前线程打印
                    while (currentThread != threadId) {
                        currentCondition.await();
                    }

                    // 如果已经打印完所有数字，退出循环
                    if (currentNumber > MAX_NUMBER) {
                        break;
                    }

                    // 打印当前数字
                    System.out.println("Thread " + threadId + ": " + currentNumber);
                    currentNumber++;

                    // 更新当前线程状态
                    currentThread = (currentThread % 3) + 1;

                    // 唤醒下一个线程
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Printer(1, condition1, condition2));
        Thread thread2 = new Thread(new Printer(2, condition2, condition3));
        Thread thread3 = new Thread(new Printer(3, condition3, condition1));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}