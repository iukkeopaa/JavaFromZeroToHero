package DesignRateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    private final int capacity; // 令牌桶容量
    private final int rate; // 令牌生成速率（每秒生成的令牌数）
    private int tokens; // 当前令牌数量
    private long lastRefillTime; // 上次填充令牌的时间

    public TokenBucketRateLimiter(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
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
        int newTokens = (int) (elapsedTime * rate / 1000);
        tokens = Math.min(capacity, tokens + newTokens);
        lastRefillTime = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(100, 10);
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