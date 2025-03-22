package LRU;

import java.util.*;

class ExpiringLRUCache<K, V> {
    private final int capacity;
    private final long expireMillis;
    private final Map<K, CacheItem<V>> cache;
    private final String policy;

    // 缓存项，包含值和过期时间
    private static class CacheItem<V> {
        V value;
        long expireTime;

        CacheItem(V value, long expireTime) {
            this.value = value;
            this.expireTime = expireTime;
        }
    }

    // 构造函数
    public ExpiringLRUCache(int capacity, long expireSeconds, String policy) {
        this.capacity = capacity;
        this.expireMillis = expireSeconds * 1000;
        this.policy = policy;

        // 使用LinkedHashMap实现LRU
        this.cache = new LinkedHashMap<K, CacheItem<V>>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheItem<V>> eldest) {
                // 当缓存大小超过容量时，移除最久未使用的项
                return size() > capacity;
            }
        };
    }

    // 获取缓存项
    public V get(K key) {
        CacheItem<V> item = cache.get(key);
        if (item == null) {
            return null; // 缓存未命中
        }

        // 检查是否过期
        if (System.currentTimeMillis() > item.expireTime) {
            cache.remove(key); // 惰性删除过期项
            // 这里返回空值
            return null;
        }

        return item.value;
    }

    // 添加缓存项
    public void put(K key, V value) {
        long expireTime = System.currentTimeMillis() + expireMillis;
        CacheItem<V> item = new CacheItem<>(value, expireTime);

        // 如果缓存已满，移除最久未使用的项
        if (cache.size() >= capacity) {
            cache.remove(cache.keySet().iterator().next());
        }

        cache.put(key, item);

        // 根据策略处理过期项
        if ("active".equals(policy)) {
            removeExpiredItems();
        }
    }

    // 移除过期项
    private void removeExpiredItems() {
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<K, CacheItem<V>>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, CacheItem<V>> entry = iterator.next();
            if (entry.getValue().expireTime < currentTime) {
                iterator.remove(); // 移除过期项
            }
        }
    }

    // 手动清理过期项
    public void cleanExpired() {
        removeExpiredItems();
    }

    // 返回缓存大小
    public int size() {
        return cache.size();
    }

    // 测试
    public static void main(String[] args) throws InterruptedException {
        ExpiringLRUCache<Integer, String> cache = new ExpiringLRUCache<>(3, 2, "active");

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache.get(1)); // 输出: A
        Thread.sleep(3000); // 等待3秒，让缓存项过期
        System.out.println(cache.get(1)); // 输出: null (已过期)
        System.out.println(cache.size()); // 输出: 0 (过期项已被移除)
    }
}