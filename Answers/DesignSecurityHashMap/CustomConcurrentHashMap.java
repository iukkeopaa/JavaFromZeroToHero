package DesignSecurityHashMap;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

// 自定义的分段锁
class Segment<K, V> {
    private final LinkedList<Entry<K, V>>[] table;
    private final ReentrantLock lock;

    @SuppressWarnings("unchecked")
    public Segment(int capacity) {
        table = new LinkedList[capacity];
        lock = new ReentrantLock();
    }

    public V get(K key) {
        lock.lock();
        try {
            int index = getIndex(key);
            LinkedList<Entry<K, V>> bucket = table[index];
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.key.equals(key)) {
                        return entry.value;
                    }
                }
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            int index = getIndex(key);
            LinkedList<Entry<K, V>> bucket = table[index];
            if (bucket == null) {
                bucket = new LinkedList<>();
                table[index] = bucket;
            }
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
            bucket.add(new Entry<>(key, value));
        } finally {
            lock.unlock();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

// 自定义的高性能线程安全 HashMap
public class CustomConcurrentHashMap<K, V> {
    private static final int DEFAULT_SEGMENTS = 16;
    private final Segment<K, V>[] segments;

    @SuppressWarnings("unchecked")
    public CustomConcurrentHashMap() {
        segments = new Segment[DEFAULT_SEGMENTS];
        for (int i = 0; i < DEFAULT_SEGMENTS; i++) {
            segments[i] = new Segment<>(16);
        }
    }

    public V get(K key) {
        int segmentIndex = getSegmentIndex(key);
        return segments[segmentIndex].get(key);
    }

    public void put(K key, V value) {
        int segmentIndex = getSegmentIndex(key);
        segments[segmentIndex].put(key, value);
    }

    private int getSegmentIndex(K key) {
        return Math.abs(key.hashCode()) % segments.length;
    }

    public static void main(String[] args) {
        CustomConcurrentHashMap<String, Integer> customMap = new CustomConcurrentHashMap<>();

        // 启动多个线程进行操作
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                customMap.put("Key" + i, i);
            }
        });

        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Integer value = customMap.get("Key" + i);
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