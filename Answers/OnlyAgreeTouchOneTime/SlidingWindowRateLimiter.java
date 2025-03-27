package OnlyAgreeTouchOneTime;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class SlidingWindowRateLimiter {
    private final int limit;
    private final int windowSize;
    private final int subWindowCount;
    private final int subWindowSize;
    private final AtomicIntegerArray counters;
    private int currentSubWindow;

    public SlidingWindowRateLimiter(int limit, long windowSize, int subWindowCount) {
        this.limit = limit;
        this.windowSize = (int) windowSize;
        this.subWindowCount = subWindowCount;
        this.subWindowSize = (int) (windowSize / subWindowCount);
        this.counters = new AtomicIntegerArray(subWindowCount);
        this.currentSubWindow = 0;
    }

    public synchronized boolean tryAcquire() {
        int currentTime = (int) (System.currentTimeMillis() % windowSize);
        int newSubWindow = currentTime / subWindowSize;
        if (newSubWindow != currentSubWindow) {
            // »¬¶¯´°¿Ú
            for (int i = currentSubWindow + 1; i <= newSubWindow; i++) {
                counters.set(i % subWindowCount, 0);
            }
            currentSubWindow = newSubWindow;
        }
        int totalCount = 0;
        for (int i = 0; i < subWindowCount; i++) {
            totalCount += counters.get(i);
        }
        if (totalCount + 1 <= limit) {
            counters.incrementAndGet(currentSubWindow);
            return true;
        }
        return false;
    }
}