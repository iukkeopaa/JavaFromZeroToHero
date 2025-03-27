package DesignSecurityHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // ����һ�� ConcurrentHashMap ʵ��
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // ��������߳̽��в���
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                concurrentMap.put("Key" + i, i);
            }
        });

        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Integer value = concurrentMap.get("Key" + i);
                if (value != null) {
                    System.out.println("Key" + i + ": " + value);
                }
            }
        });

        putThread.start();
        getThread.start();

        try {
            putThread.join();
            getThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}    