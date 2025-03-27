package List.Q146;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache1 {
    private LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        // 初始化 LinkedHashMap，设置访问顺序为 true
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}    