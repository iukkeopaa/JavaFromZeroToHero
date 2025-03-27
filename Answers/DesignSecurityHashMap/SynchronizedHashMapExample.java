package DesignSecurityHashMap;

import java.util.HashMap;
import java.util.Map;

// 自定义线程安全的 HashMap 类
class SynchronizedHashMap<K, V> {
    private final Map<K, V> map;

    // 构造函数，初始化内部的 HashMap
    public SynchronizedHashMap() {
        this.map = new HashMap<>();
    }

    // 同步的 put 方法，用于向 map 中添加键值对
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    // 同步的 get 方法，用于根据键获取值
    public synchronized V get(K key) {
        return map.get(key);
    }

    // 同步的 remove 方法，用于根据键移除键值对
    public synchronized V remove(K key) {
        return map.remove(key);
    }

    // 同步的 containsKey 方法，用于检查 map 中是否包含指定的键
    public synchronized boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // 同步的 size 方法，用于获取 map 中键值对的数量
    public synchronized int size() {
        return map.size();
    }
}

// 主类，用于测试自定义的线程安全 HashMap
public class SynchronizedHashMapExample {
    public static void main(String[] args) {
        // 创建自定义线程安全 HashMap 的实例
        SynchronizedHashMap<String, Integer> syncMap = new SynchronizedHashMap<>();

        // 启动一个线程进行 put 操作
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncMap.put("Key" + i, i);
            }
        });

        // 启动一个线程进行 get 操作
        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Integer value = syncMap.get("Key" + i);
                if (value != null) {
                    System.out.println("Key" + i + ": " + value);
                }
            }
        });

        // 启动两个线程
        putThread.start();
        getThread.start();

        try {
            // 等待 put 线程执行完毕
            putThread.join();
            // 等待 get 线程执行完毕
            getThread.join();
        } catch (InterruptedException e) {
            // 处理线程中断异常
            e.printStackTrace();
        }
    }
}    