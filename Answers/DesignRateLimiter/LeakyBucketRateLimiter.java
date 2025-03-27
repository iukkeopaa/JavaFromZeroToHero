package DesignRateLimiter;

import java.util.concurrent.TimeUnit;

public class LeakyBucketRateLimiter {
    private final int capacity; // ©Ͱ����
    private final int rate; // ©ˮ���ʣ�ÿ�봦�����������
    private int water; // ��ǰͰ�е�ˮ��������������
    private long lastLeakTime; // �ϴ�©ˮ��ʱ��

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