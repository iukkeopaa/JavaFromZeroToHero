package Question.Q9;

public class AlternatePrinting {
    // 用于控制线程交替执行的锁对象
    private static final Object lock = new Object();
    // 用于记录当前要输出的数字，初始为 1
    private static int number = 1;
    // 用于记录当前要输出的字母，初始为 'A'
    private static char letter = 'A';
    // 用于标记当前是否轮到数字线程输出，初始为 true
    private static boolean isNumberTurn = true;

    public static void main(String[] args) {
        // 创建数字线程
        Thread numberThread = new Thread(new NumberPrinter());
        // 创建字母线程
        Thread letterThread = new Thread(new LetterPrinter());

        // 启动数字线程
        numberThread.start();
        // 启动字母线程
        letterThread.start();

        try {
            // 等待数字线程执行完毕
            numberThread.join();
            // 等待字母线程执行完毕
            letterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 数字线程的任务类
    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (number <= 52) {
                    // 如果不是数字线程的回合，等待
                    while (!isNumberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 输出两个连续的数字
                    System.out.print(number);
                    number++;
                    System.out.print(number);
                    number++;
                    // 切换到字母线程的回合
                    isNumberTurn = false;
                    // 唤醒字母线程
                    lock.notify();
                }
            }
        }
    }

    // 字母线程的任务类
    static class LetterPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (letter <= 'Z') {
                    // 如果不是字母线程的回合，等待
                    while (isNumberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 输出当前字母
                    System.out.print(letter);
                    // 字母递增
                    letter++;
                    // 如果字母还未到 'Z'，输出空格
                    if (letter <= 'Z') {
                        System.out.print(" ");
                    }
                    // 切换到数字线程的回合
                    isNumberTurn = true;
                    // 唤醒数字线程
                    lock.notify();
                }
            }
        }
    }
}