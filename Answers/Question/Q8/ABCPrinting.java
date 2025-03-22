package Question.Q8;

public class ABCPrinting {
    private static final Object lock = new Object();
    // 用于标记当前应该输出的字母，初始为 'A'
    private static char currentChar = 'A';
    // 用于记录循环次数，初始为 0
    private static int count = 0;

    public static void main(String[] args) {
        // 创建输出 'A' 的线程
        Thread threadA = new Thread(new Printer('A', 'B'));
        // 创建输出 'B' 的线程
        Thread threadB = new Thread(new Printer('B', 'C'));
        // 创建输出 'C' 的线程
        Thread threadC = new Thread(new Printer('C', 'A'));

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
        private final char nextChar;

        public Printer(char myChar, char nextChar) {
            this.myChar = myChar;
            this.nextChar = nextChar;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 当循环次数达到 10 次，退出循环
                    if (count >= 10) {
                        break;
                    }
                    // 如果不是当前线程要输出的字母，线程等待
                    while (currentChar != myChar) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 输出当前字母
                    System.out.print(myChar);
                    // 如果当前输出的是 'C'，表示完成一轮循环，换行并增加循环次数
                    if (myChar == 'C') {
                        System.out.println();
                        count++;
                    }
                    // 更新当前要输出的字母
                    currentChar = nextChar;
                    // 唤醒其他等待的线程
                    lock.notifyAll();
                }
            }
        }
    }
}