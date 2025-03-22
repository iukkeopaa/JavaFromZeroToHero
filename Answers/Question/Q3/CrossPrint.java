package Question.Q3;

public class CrossPrint {
    private static final Object lock = new Object();
    private static boolean printNumber = true;

    public static void main(String[] args) {
        Thread printNumberThread = new Thread(() -> {
            for (int i = 1; i <= 52; i = i + 2) {
                synchronized (lock) {
                    while (!printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(i);
                    System.out.print(i + 1);
                    printNumber = false;
                    lock.notifyAll();
                }
            }
        });

        Thread printLetterThread = new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                synchronized (lock) {
                    while (printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(c);
                    printNumber = true;
                    lock.notifyAll();
                }
            }
        });

        printNumberThread.start();
        printLetterThread.start();
    }
}