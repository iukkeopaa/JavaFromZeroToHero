package Question.Q12;

public class FourThreadsPrinting {
    // 用于线程同步的锁对象
    private static final Object lock = new Object();
    // 用于标记当前应该输出的线程编号，初始为 1
    private static int currentThread = 1;
    // 循环次数
    private static final int LOOP_TIMES = 5;

    public static void main(String[] args) {
        // 创建输出 'A' 的线程
        Thread thread1 = new Thread(new Printer(1, 'A'));
        // 创建输出 'B' 的线程
        Thread thread2 = new Thread(new Printer(2, 'B'));
        // 创建输出 'C' 的线程
        Thread thread3 = new Thread(new Printer(3, 'C'));
        // 创建输出 'D' 的线程
        Thread thread4 = new Thread(new Printer(4, 'D'));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Printer implements Runnable {
        private final int threadNumber;
        private final char outputChar;

        public Printer(int threadNumber, char outputChar) {
            this.threadNumber = threadNumber;
            this.outputChar = outputChar;
        }

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIMES; i++) {
                synchronized (lock) {
                    // 如果不是当前线程编号，线程等待
                    while (currentThread != threadNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 输出对应的字符
                    System.out.print(outputChar);
                    // 更新当前线程编号
                    currentThread = (currentThread % 4) + 1;
                    // 唤醒其他等待的线程
                    lock.notifyAll();
                }
            }
        }
    }
}