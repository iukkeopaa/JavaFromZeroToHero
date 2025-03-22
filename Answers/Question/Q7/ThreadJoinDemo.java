package Question.Q7;

public class ThreadJoinDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("T1"), "T1");
        Thread t2 = new Thread(new Task("T2"), "T2");
        Thread t3 = new Thread(new Task("T3"), "T3");

        executeThreadsSequentially(t1, t2, t3);
    }

    private static void executeThreadsSequentially(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("线程 " + thread.getName() + " 被中断");
                return;
            }
        }
    }

    private static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            System.out.println(name + " 开始执行！");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(name + " 被中断");
                return;
            }
            System.out.println(name + " 执行完毕！");
            long endTime = System.currentTimeMillis();
            System.out.println(name + " 执行时间:" + (endTime - startTime) + "ms");
            System.out.println("--------------------------------");
        }
    }
}