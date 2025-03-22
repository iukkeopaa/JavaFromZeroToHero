package Question.Q10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OrderedNumberPrinting {
    private static final ReentrantLock lock = new ReentrantLock();
    // 线程 1 的 Condition 对象
    private static final Condition condition1 = lock.newCondition();
    // 线程 2 的 Condition 对象
    private static final Condition condition2 = lock.newCondition();
    // 线程 3 的 Condition 对象
    private static final Condition condition3 = lock.newCondition();
    // 当前要打印的数字，初始为 1
    private static int currentNumber = 1;
    // 当前轮到的线程编号，初始为 1
    private static int currentThread = 1;

    public static void main(String[] args) {
        // 创建线程 1
        Thread thread1 = new Thread(new Printer(1, condition1, condition2));
        // 创建线程 2
        Thread thread2 = new Thread(new Printer(2, condition2, condition3));
        // 创建线程 3
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
            lock.lock();
            try {
                while (currentNumber <= 75) {
                    // 若不是当前线程打印，等待
                    while (currentThread != threadId) {
                        currentCondition.await();
                    }
                    // 打印 5 个数字
                    for (int i = 0; i < 5 && currentNumber <= 75; i++) {
                        System.out.println("线程 " + threadId + " 打印: " + currentNumber);
                        currentNumber++;
                    }
                    // 更新当前轮到的线程编号
                    currentThread = (currentThread % 3) + 1;
                    // 唤醒下一个线程
                    nextCondition.signal();
                    // 若不是最后一个线程且还有数字要打印，当前线程等待
                    if (currentNumber <= 75 && currentThread != threadId) {
                        currentCondition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
