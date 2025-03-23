package DaChangBrushUpClass.class1.class2.class1.Class2;

import java.util.HashMap;


//设计有setAll功能的哈希表，put、get、setAll方法，时间复杂度O(1)
public class SetAll {

    public static class MyValue<V> {
        public V value;
        public long time;

        public MyValue(V v, long t) {
            value = v;
            time = t;
        }
    }

    public static class MyHashMap<K, V> {
        private HashMap<K, MyValue<V>> map;
        private long time;
        private MyValue<V> setAll;

        public MyHashMap() {
            map = new HashMap<>();
            time = 0;
            setAll = new MyValue<V>(null, -1);
        }

        public void put(K key, V value) {
            map.put(key, new MyValue<V>(value, time++));
        }

        public void setAll(V value) {
            setAll = new MyValue<V>(value, time++);
        }

        public V get(K key) {
            if (!map.containsKey(key)) {
                return null;
            }
            if (map.get(key).time > setAll.time) {
                return map.get(key).value;
            } else {
                return setAll.value;
            }
        }
    }



    class CustomHashMap<K, V> {
        private HashMap<K, V> map;
        private V allValue;
        private boolean allSet;

        public CustomHashMap() {
            map = new HashMap<>();
            allValue = null;
            allSet = false;
        }

        public void put(K key, V value) {
            if (allSet) {
                map.put(key, value);
            } else {
                map.put(key, value);
            }
        }

        public V get(K key) {
            if (allSet &&!map.containsKey(key)) {
                return allValue;
            }
            return map.get(key);
        }

        public void setAll(V value) {
            allValue = value;
            allSet = true;
            map.clear();
        }
        public final void main(String[] args) {
            CustomHashMap<String, Integer> customMap = new CustomHashMap<>();

            // 插入一些键值对
            customMap.put("apple", 10);
            customMap.put("banana", 20);

            // 获取值
            System.out.println("Value of apple: " + customMap.get("apple")); // 输出: 10
            System.out.println("Value of banana: " + customMap.get("banana")); // 输出: 20

            // 调用 setAll 方法
            customMap.setAll(30);

            // 获取之前存在的键的值
            System.out.println("Value of apple after setAll: " + customMap.get("apple")); // 输出: 30
            System.out.println("Value of banana after setAll: " + customMap.get("banana")); // 输出: 30

            // 插入新的键值对
            customMap.put("cherry", 40);

            // 获取值
            System.out.println("Value of cherry: " + customMap.get("cherry")); // 输出: 40
            System.out.println("Value of apple after put cherry: " + customMap.get("apple")); // 输出: 30
        }

    }




}
