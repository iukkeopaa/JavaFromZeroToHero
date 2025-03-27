package OnlyAgreeTouchOneTime;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    private final int capacity;
    private final int rate;
    private int tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean tryAcquire() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTime;
        int newTokens = (int) (elapsedTime * rate / TimeUnit.SECONDS.toMillis(1));
        tokens = Math.min(capacity, tokens + newTokens);
        lastRefillTime = now;
    }
}