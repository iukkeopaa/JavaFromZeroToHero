package OnlyAgreeTouchOneTime;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucketRateLimiter {
    private final int capacity;
    private final int rate;
    private final BlockingQueue<Integer> bucket;

    public LeakyBucketRateLimiter(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.bucket = new LinkedBlockingQueue<>(capacity);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000 / rate);
                    if (!bucket.isEmpty()) {
                        bucket.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean tryAcquire() {
        return bucket.offer(1);
    }
}