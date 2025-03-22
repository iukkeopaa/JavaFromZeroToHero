package LRU;

import java.util.*;
import java.util.concurrent.*;

public class LRU {


    // 过期策略枚举
    enum ExpirationPolicy {
        ACTIVE, // 主动过期
        TIMED   // 定时过期
    }
   public static class LRUImplementsVersion1<K,V>{
       private final int capacity;
       private final LinkedHashMap<K, V> cache;
       private final Map<K, Long> expirationTimes;
       private final ExpirationPolicy policy;
       private final ScheduledExecutorService scheduler;

       public LRUImplementsVersion1(int capacity, ExpirationPolicy policy) {
           this.capacity = capacity;
           this.policy = policy;
           this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
               @Override
               protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                   return size() > capacity;
               }
           };
           this.expirationTimes = new HashMap<>();
           if (policy == ExpirationPolicy.TIMED) {
               this.scheduler = Executors.newScheduledThreadPool(1);
               // 每 1 秒检查一次过期元素
               scheduler.scheduleAtFixedRate(this::removeExpiredEntries, 1, 1, TimeUnit.SECONDS);
           } else {
               this.scheduler = null;
           }
       }

       public void put(K key, V value, long expirationMillis) {
           cache.put(key, value);
           expirationTimes.put(key, System.currentTimeMillis() + expirationMillis);
           // 主动过期策略下，插入后检查是否有过期元素
           if (policy == ExpirationPolicy.ACTIVE) {
               removeExpiredEntries();
           }
       }

       // 从缓存中获取元素
       public V get(K key) {
           if (cache.containsKey(key)) {
               if (isExpired(key)) {
                   // 元素已过期，移除并返回 null
                   cache.remove(key);
                   expirationTimes.remove(key);
                   return null;
               }
               return cache.get(key);
           }
           return null;
       }

       // 检查元素是否过期
       private boolean isExpired(K key) {
           Long expirationTime = expirationTimes.get(key);
           return expirationTime != null && System.currentTimeMillis() > expirationTime;
       }

       // 移除过期元素
       private void removeExpiredEntries() {
           Iterator<Map.Entry<K, Long>> iterator = expirationTimes.entrySet().iterator();
           while (iterator.hasNext()) {
               Map.Entry<K, Long> entry = iterator.next();
               if (System.currentTimeMillis() > entry.getValue()) {
                   cache.remove(entry.getKey());
                   iterator.remove();
               }
           }
       }

       // 关闭定时任务
       public void shutdown() {
           if (scheduler != null) {
               scheduler.shutdown();
           }
       }
   }






    public static void main(String[] args) {
        LRUImplementsVersion1<String, String> cache = new LRUImplementsVersion1<>(3, ExpirationPolicy.ACTIVE);

        // 插入元素，设置过期时间为 2 秒
        cache.put("key1", "value1", 2000);
        cache.put("key2", "value2", 3000);
        cache.put("key3", "value3", 1000);

        // 打印元素
        System.out.println(cache.get("key1")); // 输出: value1
        System.out.println(cache.get("key2")); // 输出: value2
        System.out.println(cache.get("key3")); // 输出: null，因为已过期

        // 关闭缓存
        cache.shutdown();
    }

}
