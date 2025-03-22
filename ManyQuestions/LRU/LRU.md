### 写一个带过期时间的LRU，并且实现不同的过期策略


### 实现思路



- **LRU.LRU 缓存结构**：使用 `LinkedHashMap` 来实现 LRU.LRU 缓存，它可以维护元素的访问顺序，当缓存满时，自动移除最旧的元素。
- **过期时间管理**：为每个缓存项添加一个过期时间戳，通过定时任务或者在访问时检查过期情况。
- **过期策略**：支持两种常见的过期策略，分别是惰性删除（在访问时检查过期）和定期删除（定时清理过期元素）。

### 代码实现



java











```java
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// 缓存项类，包含值和过期时间戳
class CacheItem<V> {
    V value;
    long expirationTime;

    public CacheItem(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }
}

// 带过期时间的 LRU.LRU 缓存类
public class LRU.ExpiringLRUCache<K, V> extends LinkedHashMap<K, CacheItem<V>> {
    private final int capacity;
    private final long defaultExpiration;
    private final ExpirationStrategy strategy;

    // 过期策略枚举
    public enum ExpirationStrategy {
        LAZY_DELETION, // 惰性删除
        PERIODIC_DELETION // 定期删除
    }

    public LRU.ExpiringLRUCache(int capacity, long defaultExpiration, ExpirationStrategy strategy) {
        super(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheItem<V>> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
        this.defaultExpiration = defaultExpiration;
        this.strategy = strategy;

        if (strategy == ExpirationStrategy.PERIODIC_DELETION) {
            // 启动定期删除任务
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(this::removeExpiredEntries, 0, defaultExpiration / 2, TimeUnit.MILLISECONDS);
        }
    }

    // 放入缓存项，使用默认过期时间
    public void put(K key, V value) {
        put(key, value, defaultExpiration);
    }

    // 放入缓存项，指定过期时间
    public void put(K key, V value, long expiration) {
        long expirationTime = System.currentTimeMillis() + expiration;
        super.put(key, new CacheItem<>(value, expirationTime));
    }

    // 获取缓存项
    @Override
    public CacheItem<V> get(Object key) {
        CacheItem<V> item = super.get(key);
        if (item != null) {
            if (strategy == ExpirationStrategy.LAZY_DELETION && isExpired(item)) {
                // 惰性删除：访问时检查并删除过期项
                remove(key);
                return null;
            }
        }
        return item;
    }

    // 检查缓存项是否过期
    private boolean isExpired(CacheItem<V> item) {
        return System.currentTimeMillis() > item.expirationTime;
    }

    // 移除过期的缓存项
    private void removeExpiredEntries() {
        Iterator<Map.Entry<K, CacheItem<V>>> iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, CacheItem<V>> entry = iterator.next();
            if (isExpired(entry.getValue())) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个容量为 3，默认过期时间为 5 秒，使用惰性删除策略的缓存
        LRU.ExpiringLRUCache<String, String> cache = new LRU.ExpiringLRUCache<>(3, 5000, LRU.ExpiringLRUCache.ExpirationStrategy.LAZY_DELETION);

        // 放入缓存项
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        // 获取缓存项
        System.out.println(cache.get("key1").value);

        try {
            // 等待 6 秒，让缓存项过期
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 再次获取过期的缓存项
        System.out.println(cache.get("key1"));
    }
}
```

### 代码解释



1. **`CacheItem` 类**：用于存储缓存项的值和过期时间戳。

2. `LRU.ExpiringLRUCache` 类

   ：

    - 继承自 `LinkedHashMap`，并重写 `removeEldestEntry` 方法，当缓存大小超过容量时，自动移除最旧的元素。
    - 支持两种过期策略：
        - **LAZY_DELETION（惰性删除）**：在访问缓存项时检查是否过期，如果过期则删除该缓存项。
        - **PERIODIC_DELETION（定期删除）**：使用 `ScheduledExecutorService` 定时执行 `removeExpiredEntries` 方法，清理过期的缓存项。
    - `put` 方法：用于向缓存中放入元素，可以指定过期时间，也可以使用默认过期时间。
    - `get` 方法：用于获取缓存项，如果使用惰性删除策略，会在访问时检查并删除过期项。
    - `isExpired` 方法：用于检查缓存项是否过期。
    - `removeExpiredEntries` 方法：用于移除过期的缓存项。

### 复杂度分析



- 时间复杂度

  ：

    - `put` 操作：\(O(1)\)，因为 `LinkedHashMap` 的插入操作时间复杂度为 \(O(1)\)。
    - `get` 操作：\(O(1)\)，在不考虑过期检查的情况下，`LinkedHashMap` 的查找操作时间复杂度为 \(O(1)\)。如果使用惰性删除策略，可能会有额外的过期检查和删除操作，但平均时间复杂度仍为 \(O(1)\)。

- **空间复杂度**：\(O(n)\)，其中 n 是缓存的容量，主要用于存储缓存项。


除了轮询（定期删除）的方式来处理带过期时间的 LRU.LRU 缓存中的过期数据，还可以采用以下几种常见方法：

### 1. 惰性删除与事件驱动结合

- 原理

  ：

    - 惰性删除在每次访问缓存时检查元素是否过期，如果过期则删除该元素。在此基础上，结合事件驱动机制，当数据库或其他数据源发生变化时，主动触发缓存更新或过期元素的删除操作。

- 实现步骤

  ：

    - 定义一个事件监听器，监听数据源的变化事件，例如数据库的插入、更新、删除操作。
    - 当事件发生时，根据事件的类型和涉及的数据，更新或删除缓存中相应的元素。

- **示例代码（Java）**：

java











```java
import java.util.*;

// 缓存项类，包含值和过期时间戳
class CacheItem<V> {
    V value;
    long expirationTime;

    public CacheItem(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }
}

// 带过期时间的 LRU.LRU 缓存类
public class LRU.ExpiringLRUCache<K, V> extends LinkedHashMap<K, CacheItem<V>> {
    private final int capacity;
    private final long defaultExpiration;

    public LRU.ExpiringLRUCache(int capacity, long defaultExpiration) {
        super(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheItem<V>> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
        this.defaultExpiration = defaultExpiration;
    }

    // 放入缓存项，使用默认过期时间
    public void put(K key, V value) {
        put(key, value, defaultExpiration);
    }

    // 放入缓存项，指定过期时间
    public void put(K key, V value, long expiration) {
        long expirationTime = System.currentTimeMillis() + expiration;
        super.put(key, new CacheItem<>(value, expirationTime));
    }

    // 获取缓存项
    @Override
    public CacheItem<V> get(Object key) {
        CacheItem<V> item = super.get(key);
        if (item != null && isExpired(item)) {
            // 惰性删除：访问时检查并删除过期项
            remove(key);
            return null;
        }
        return item;
    }

    // 检查缓存项是否过期
    private boolean isExpired(CacheItem<V> item) {
        return System.currentTimeMillis() > item.expirationTime;
    }

    // 事件驱动的缓存更新或删除
    public void handleEvent(K key) {
        CacheItem<V> item = super.get(key);
        if (item != null) {
            remove(key);
        }
    }

    public static void main(String[] args) {
        LRU.ExpiringLRUCache<String, String> cache = new LRU.ExpiringLRUCache<>(3, 5000);
        cache.put("key1", "value1");
        System.out.println(cache.get("key1").value);
        // 模拟事件触发
        cache.handleEvent("key1");
        System.out.println(cache.get("key1"));
    }
}
```

### 2. 定时器与任务队列

- 原理

  ：

    - 为每个缓存项创建一个定时器任务，当缓存项的过期时间到达时，将对应的删除任务添加到任务队列中。然后有一个单独的线程从任务队列中取出任务并执行删除操作。

- 实现步骤

  ：

    - 在添加缓存项时，创建一个 `TimerTask` 或 `ScheduledFuture` 任务，设置任务的执行时间为缓存项的过期时间。
    - 当任务执行时，将删除操作添加到任务队列中。
    - 启动一个线程不断从任务队列中取出任务并执行。

- **示例代码（Java）**：

java











```java
import java.util.*;
import java.util.concurrent.*;

// 缓存项类，包含值和过期时间戳
class CacheItem<V> {
    V value;
    long expirationTime;

    public CacheItem(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }
}

// 带过期时间的 LRU.LRU 缓存类
public class LRU.ExpiringLRUCache<K, V> extends LinkedHashMap<K, CacheItem<V>> {
    private final int capacity;
    private final long defaultExpiration;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final BlockingQueue<K> removalQueue = new LinkedBlockingQueue<>();

    public LRU.ExpiringLRUCache(int capacity, long defaultExpiration) {
        super(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheItem<V>> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
        this.defaultExpiration = defaultExpiration;

        // 启动删除任务处理线程
        new Thread(() -> {
            try {
                while (true) {
                    K key = removalQueue.take();
                    remove(key);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    // 放入缓存项，使用默认过期时间
    public void put(K key, V value) {
        put(key, value, defaultExpiration);
    }

    // 放入缓存项，指定过期时间
    public void put(K key, V value, long expiration) {
        long expirationTime = System.currentTimeMillis() + expiration;
        super.put(key, new CacheItem<>(value, expirationTime));
        scheduler.schedule(() -> {
            if (isExpired(get(key))) {
                removalQueue.add(key);
            }
        }, expiration, TimeUnit.MILLISECONDS);
    }

    // 获取缓存项
    @Override
    public CacheItem<V> get(Object key) {
        CacheItem<V> item = super.get(key);
        if (item != null && isExpired(item)) {
            // 惰性删除：访问时检查并删除过期项
            remove(key);
            return null;
        }
        return item;
    }

    // 检查缓存项是否过期
    private boolean isExpired(CacheItem<V> item) {
        return item != null && System.currentTimeMillis() > item.expirationTime;
    }

    public static void main(String[] args) {
        LRU.ExpiringLRUCache<String, String> cache = new LRU.ExpiringLRUCache<>(3, 5000);
        cache.put("key1", "value1");
        System.out.println(cache.get("key1").value);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.get("key1"));
    }
}
```

### 3. 基于时间轮算法

- 原理

  ：

    - 时间轮是一种高效的定时器实现方式，它将时间划分为多个槽，每个槽代表一个时间间隔。每个缓存项根据其过期时间被分配到相应的槽中。随着时间的推移，时间轮不断转动，当某个槽被转到当前位置时，处理该槽中的所有过期缓存项。

- 实现步骤

  ：

    - 初始化一个时间轮，设置槽的数量和每个槽的时间间隔。
    - 在添加缓存项时，根据其过期时间计算应该放入哪个槽中。
    - 启动一个线程不断转动时间轮，处理当前槽中的过期缓存项。

- **示例代码（简化版）**：

java











```java
import java.util.*;

// 缓存项类，包含值和过期时间戳
class CacheItem<V> {
    V value;
    long expirationTime;

    public CacheItem(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }
}

// 时间轮槽
class TimeSlot<K, V> {
    Map<K, CacheItem<V>> items = new HashMap<>();
}

// 时间轮
class TimeWheel<K, V> {
    private final int slots;
    private final long interval;
    private final TimeSlot<K, V>[] wheel;
    private int currentSlot = 0;

    @SuppressWarnings("unchecked")
    public TimeWheel(int slots, long interval) {
        this.slots = slots;
        this.interval = interval;
        this.wheel = new TimeSlot[slots];
        for (int i = 0; i < slots; i++) {
            wheel[i] = new TimeSlot<>();
        }
        // 启动时间轮转动线程
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(interval);
                    rotate();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void add(K key, CacheItem<V> item) {
        long expiration = item.expirationTime - System.currentTimeMillis();
        int slotIndex = (currentSlot + (int) (expiration / interval)) % slots;
        wheel[slotIndex].items.put(key, item);
    }

    private void rotate() {
        TimeSlot<K, V> current = wheel[currentSlot];
        Iterator<Map.Entry<K, CacheItem<V>>> iterator = current.items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, CacheItem<V>> entry = iterator.next();
            if (System.currentTimeMillis() > entry.getValue().expirationTime) {
                iterator.remove();
                // 可以在这里添加具体的删除逻辑，如从缓存中移除
            }
        }
        currentSlot = (currentSlot + 1) % slots;
    }
}

// 带过期时间的 LRU.LRU 缓存类
public class LRU.ExpiringLRUCache<K, V> extends LinkedHashMap<K, CacheItem<V>> {
    private final int capacity;
    private final long defaultExpiration;
    private final TimeWheel<K, V> timeWheel;

    public LRU.ExpiringLRUCache(int capacity, long defaultExpiration, int timeWheelSlots, long timeWheelInterval) {
        super(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheItem<V>> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
        this.defaultExpiration = defaultExpiration;
        this.timeWheel = new TimeWheel<>(timeWheelSlots, timeWheelInterval);
    }

    // 放入缓存项，使用默认过期时间
    public void put(K key, V value) {
        put(key, value, defaultExpiration);
    }

    // 放入缓存项，指定过期时间
    public void put(K key, V value, long expiration) {
        long expirationTime = System.currentTimeMillis() + expiration;
        CacheItem<V> item = new CacheItem<>(value, expirationTime);
        super.put(key, item);
        timeWheel.add(key, item);
    }

    // 获取缓存项
    @Override
    public CacheItem<V> get(Object key) {
        CacheItem<V> item = super.get(key);
        if (item != null && System.currentTimeMillis() > item.expirationTime) {
            remove(key);
            return null;
        }
        return item;
    }

    public static void main(String[] args) {
        LRU.ExpiringLRUCache<String, String> cache = new LRU.ExpiringLRUCache<>(3, 5000, 10, 1000);
        cache.put("key1", "value1");
        System.out.println(cache.get("key1").value);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.get("key1"));
    }
}
```





