package DesignRateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    private final int capacity; // ����Ͱ����
    private final int rate; // �����������ʣ�ÿ�����ɵ���������
    private int tokens; // ��ǰ��������
    private long lastRefillTime; // �ϴ�������Ƶ�ʱ��

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