package OnlyAgreeTouchOneTime;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter {
    private final int limit;
    private final long windowSize;
    private long currentWindowStart;
    private AtomicInteger counter;

    public FixedWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.currentWindowStart = System.currentTimeMillis();
        this.counter = new AtomicInteger(0);
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        if (now - currentWindowStart > windowSize) {
            // ¿ªÆôÐÂ´°¿Ú
            currentWindowStart = now;
            counter.set(0);
        }
        if (counter.incrementAndGet() <= limit) {
            return true;
        }
        return false;
    }
}