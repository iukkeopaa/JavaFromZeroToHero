package DesignRateLimiter;

import java.util.concurrent.TimeUnit;

public class LeakyBucketRateLimiter {
    private final int capacity; // 漏桶容量
    private final int rate; // 漏水速率（每秒处理的请求数）
    private int water; // 当前桶中的水量（请求数量）
    private long lastLeakTime; // 上次漏水的时间

    public LeakyBucketRateLimiter(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.water = 0;
        this.lastLeakTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        leak();
        if (water < capacity) {
            water++;
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastLeakTime;
        int leakedWater = (int) (elapsedTime * rate / 1000);
        water = Math.max(0, water - leakedWater);
        lastLeakTime = now;
    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketRateLimiter limiter = new LeakyBucketRateLimiter(100, 10);
        for (int i = 0; i < 20; i++) {
            if (limiter.allowRequest()) {
                System.out.println("Request " + i + " is allowed.");
            } else {
                System.out.println("Request " + i + " is blocked.");
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}    