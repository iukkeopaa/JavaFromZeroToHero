package HashMap;

import java.util.Objects;

// 自定义的 HashMap 类
class MyHashMap<K, V> {
    // 默认初始容量
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    // 负载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 存储元素的数组
    private Node<K, V>[] table;
    // 元素数量
    private int size;

    // 节点类，用于存储键值对
    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 构造函数，初始化数组
    public MyHashMap() {
        table = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    }

    // 计算哈希值
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // 放入键值对
    public void put(K key, V value) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;
        Node<K, V> newNode = new Node<>(hash, key, value, null);

        if (table[index] == null) {
            // 该位置没有元素，直接插入
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while (true) {
                if (Objects.equals(current.key, key)) {
                    // 键已存在，更新值
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    // 到达链表尾部，插入新节点
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
        size++;
        // 检查是否需要扩容
        if ((float) size / table.length > DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    // 获取键对应的值
    public V get(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;
        Node<K, V> current = table[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // 扩容操作
    private void resize() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        for (Node<K, V> node : table) {
            while (node != null) {
                int newIndex = (newCapacity - 1) & node.hash;
                Node<K, V> next = node.next;
                node.next = newTable[newIndex];
                newTable[newIndex] = node;
                node = next;
            }
        }
        table = newTable;
    }

    // 获取元素数量
    public int size() {
        return size;
    }
}

// 测试代码
public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map.get("apple")); 
        System.out.println(map.get("banana")); 
        System.out.println(map.get("cherry")); 
        System.out.println(map.size()); 
    }
}