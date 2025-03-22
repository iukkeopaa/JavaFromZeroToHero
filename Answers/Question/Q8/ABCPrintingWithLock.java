package Question.Q8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ABCPrintingWithLock {
    private static final ReentrantLock lock = new ReentrantLock();
    // 对应输出 'A' 线程的 Condition 对象
    private static final Condition conditionA = lock.newCondition();
    // 对应输出 'B' 线程的 Condition 对象
    private static final Condition conditionB = lock.newCondition();
    // 对应输出 'C' 线程的 Condition 对象
    private static final Condition conditionC = lock.newCondition();
    // 用于标记当前应该输出的字母，初始为 'A'
    private static char currentChar = 'A';
    // 用于记录循环次数，初始为 0
    private static int count = 0;

    public static void main(String[] args) {
        // 创建输出 'A' 的线程
        Thread threadA = new Thread(new Printer('A', conditionA, conditionB));
        // 创建输出 'B' 的线程
        Thread threadB = new Thread(new Printer('B', conditionB, conditionC));
        // 创建输出 'C' 的线程
        Thread threadC = new Thread(new Printer('C', conditionC, conditionA));

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Printer implements Runnable {
        private final char myChar;
        private final Condition myCondition;
        private final Condition nextCondition;

        public Printer(char myChar, Condition myCondition, Condition nextCondition) {
            this.myChar = myChar;
            this.myCondition = myCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    // 当循环次数达到 10 次，退出循环
                    if (count >= 10) {
                        break;
                    }
                    // 如果不是当前线程要输出的字母，线程等待
                    while (currentChar != myChar) {
                        myCondition.await();
                    }
                    // 输出当前字母
                    System.out.print(myChar);
                    // 如果当前输出的是 'C'，表示完成一轮循环，换行并增加循环次数
                    if (myChar == 'C') {
                        System.out.println();
                        count++;
                    }
                    // 更新当前要输出的字母
                    currentChar = (char) (myChar + 1);
                    if (currentChar > 'C') {
                        currentChar = 'A';
                    }
                    // 唤醒下一个线程
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}