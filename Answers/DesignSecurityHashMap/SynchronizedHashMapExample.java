package DesignSecurityHashMap;

import java.util.HashMap;
import java.util.Map;

// �Զ����̰߳�ȫ�� HashMap ��
class SynchronizedHashMap<K, V> {
    private final Map<K, V> map;

    // ���캯������ʼ���ڲ��� HashMap
    public SynchronizedHashMap() {
        this.map = new HashMap<>();
    }

    // ͬ���� put ������������ map ����Ӽ�ֵ��
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    // ͬ���� get ���������ڸ��ݼ���ȡֵ
    public synchronized V get(K key) {
        return map.get(key);
    }

    // ͬ���� remove ���������ڸ��ݼ��Ƴ���ֵ��
    public synchronized V remove(K key) {
        return map.remove(key);
    }

    // ͬ���� containsKey ���������ڼ�� map ���Ƿ����ָ���ļ�
    public synchronized boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // ͬ���� size ���������ڻ�ȡ map �м�ֵ�Ե�����
    public synchronized int size() {
        return map.size();
    }
}

// ���࣬���ڲ����Զ�����̰߳�ȫ HashMap
public class SynchronizedHashMapExample {
    public static void main(String[] args) {
        // �����Զ����̰߳�ȫ HashMap ��ʵ��
        SynchronizedHashMap<String, Integer> syncMap = new SynchronizedHashMap<>();

        // ����һ���߳̽��� put ����
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncMap.put("Key" + i, i);
            }
        });

        // ����һ���߳̽��� get ����
        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Integer value = syncMap.get("Key" + i);
                if (value != null) {
                    System.out.println("Key" + i + ": " + value);
                }
            }
        });

        // ���������߳�
        putThread.start();
        getThread.start();

        try {
            // �ȴ� put �߳�ִ�����
            putThread.join();
            // �ȴ� get �߳�ִ�����
            getThread.join();
        } catch (InterruptedException e) {
            // �����߳��ж��쳣
            e.printStackTrace();
        }
    }
}    