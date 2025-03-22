package Limter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    private final int capacity; // 桶的容量
    private final double refillRate; // 令牌填充速率（每秒）
    private double tokens; // 当前令牌数量
    private long lastRefillTime; // 上次填充时间

    public TokenBucketRateLimiter(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity; // 初始时桶是满的
        this.lastRefillTime = System.nanoTime();
    }

    // 尝试获取令牌
    public synchronized boolean tryAcquire(int permits) {
        refillTokens(); // 先填充令牌
        if (tokens >= permits) {
            tokens -= permits; // 消耗令牌
            return true;
        }
        return false; // 令牌不足
    }

    // 填充令牌
    private void refillTokens() {
        long now = System.nanoTime();
        double elapsedTime = (now - lastRefillTime) / 1_000_000_000.0; // 转换为秒
        double newTokens = elapsedTime * refillRate; // 计算新增令牌
        tokens = Math.min(capacity, tokens + newTokens); // 不能超过容量
        lastRefillTime = now; // 更新上次填充时间
    }

    // 测试
    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(10, 2); // 容量 10，每秒填充 2 个令牌

        for (int i = 0; i < 20; i++) {
            if (rateLimiter.tryAcquire(1)) {
                System.out.println("Request " + (i + 1) + ": Allowed");
            } else {
                System.out.println("Request " + (i + 1) + ": Denied");
            }
            Thread.sleep(200); // 模拟请求间隔
        }
    }
}