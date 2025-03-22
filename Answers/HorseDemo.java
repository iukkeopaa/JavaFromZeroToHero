import java.util.concurrent.CountDownLatch;

public class HorseDemo {


    public static class Horse implements Runnable {

        private final int horseNumber;
        private final CountDownLatch startLatch;
        private final CountDownLatch finishLatch;

        public Horse(int horseNumber, CountDownLatch startLatch, CountDownLatch finishLatch) {
            this.horseNumber = horseNumber;
            this.startLatch = startLatch;
            this.finishLatch = finishLatch;
        }

        @Override
        public void run() {

            try {
                System.out.println("马 " + horseNumber + " 已就绪");
                // 表示这匹马已经就绪，将 startLatch 的计数器减 1
                startLatch.countDown();
                // 等待所有马都就绪，也就是 startLatch 的计数器变为 0
                startLatch.await();

                System.out.println("马 " + horseNumber + " 开始跑");
                // 模拟马跑步的时间，随机睡眠一段时间
                Thread.sleep((long) (Math.random() * 5000));
                System.out.println("马 " + horseNumber + " 跑完了");
                // 表示这匹马已经跑完，将 finishLatch 的计数器减 1
                finishLatch.countDown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public static class HorseRace {
        public static void main(String[] args) {
            final int HORSE_COUNT = 10;
            // 用于确保所有马都就绪后才开始比赛
            CountDownLatch startLatch = new CountDownLatch(HORSE_COUNT);
            // 用于等待所有马都跑完后才宣布比赛结束
            CountDownLatch finishLatch = new CountDownLatch(HORSE_COUNT);


            // 创建并启动 10 个马线程
            for (int i = 1; i <= HORSE_COUNT; i++) {
                Thread horseThread = new Thread(new Horse(i, startLatch, finishLatch));
                horseThread.start();
            }
            try {
                // 等待所有马都跑完
                finishLatch.await();
                System.out.println("所有马都跑完了，比赛结束！");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

