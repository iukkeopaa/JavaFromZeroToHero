package AlternatePrintingThreeThreads;

public class AlternatePrintingThreeThreads {
    /**
     * 当前要打印的数字
     */
    private int currentNumber = 1;
    /**
     * 用于同步的锁对象
     */
    private final Object lock = new Object();
    /**
     * 控制哪个线程应该打印的标识 0:3n ,1:3n + 1,2: 3n + 2
     */
    private int turn = 0;

    public static void main(String[] args) {
        AlternatePrintingThreeThreads ap = new AlternatePrintingThreeThreads();

        // 创建并启动三个线程
        Thread t1 = new Thread(() -> ap.printNumbers(0));
        Thread t2 = new Thread(() -> ap.printNumbers(1));
        Thread t3 = new Thread(() -> ap.printNumbers(2));

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 根据 turn 的值打印对应范围的数字
     *
     * @param offset 0:3n 1:3n+1 2:3n+2
     */
    private void printNumbers(int offset) {
        while (currentNumber <= 100) {
            synchronized (lock) {
                // 检查当前是否轮到该线程打印
                while ((turn % 3) != offset) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // 恢复中断状态并退出线程
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                // 检查当前数字是否不超过 100 且符合该线程的打印规律
                if (currentNumber <= 100 && (currentNumber - 1) % 3 == offset) {
                    System.out.println("Thread " + (offset + 1) + " printed: " + currentNumber);
                    currentNumber++;
                    // 更新 turn 标识，切换到下一个线程
                    turn = (turn + 1) % 3;
                    // 唤醒所有等待的线程
                    lock.notifyAll();
                }
            }
        }
    }
}