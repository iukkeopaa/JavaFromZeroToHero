package DesignCounter;

import java.util.concurrent.atomic.AtomicInteger;

class SafeCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    // ���Ӽ���
    public void increment() {
        count.incrementAndGet();
    }

    // ���ټ���
    public void decrement() {
        count.decrementAndGet();
    }

    // ��ȡ��ǰ����ֵ
    public int getCount() {
        return count.get();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        int threadCount = 100;
        Thread[] threads = new Thread[threadCount];

        // �����������߳�
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // �ȴ������߳�ִ�����
        for (Thread thread : threads) {
            thread.join();
        }

        // ������ռ���ֵ
        System.out.println("���ռ���ֵ: " + counter.getCount());
    }
}

//class SafeCounter {
//    private int count = 0;
//
//    // ���Ӽ�����ͬ������
//    public synchronized void increment() {
//        count++;
//    }
//
//    // ���ټ�����ͬ������
//    public synchronized void decrement() {
//        count--;
//    }
//
//    // ��ȡ��ǰ����ֵ��ͬ������
//    public synchronized int getCount() {
//        return count;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        SafeCounter counter = new SafeCounter();
//        int threadCount = 100;
//        Thread[] threads = new Thread[threadCount];
//
//        // �����������߳�
//        for (int i = 0; i < threadCount; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    counter.increment();
//                }
//            });
//            threads[i].start();
//        }
//
//        // �ȴ������߳�ִ�����
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        // ������ռ���ֵ
//        System.out.println("���ռ���ֵ: " + counter.getCount());
//    }
//}