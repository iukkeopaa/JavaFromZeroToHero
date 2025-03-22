package HashMap;

public class MyHashMap1<K, V> {
    private static final int DEFAULT_CAPACITY = 16; // 默认初始容量
    private static final float LOAD_FACTOR = 0.75f; // 负载因子

    private Node<K, V>[] table; // 存储键值对的数组
    private int size; // 当前元素数量

    // 节点类，用于存储键值对
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 构造函数
    public MyHashMap1() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    // 插入键值对
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Node<K, V> node = table[index];

        // 遍历链表，检查是否已存在相同的 key
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value; // 更新值
                return;
            }
            node = node.next;
        }

        // 插入新节点到链表头部
        table[index] = new Node<>(key, value, table[index]);
        size++;

        // 检查是否需要扩容
        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    // 获取值
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Node<K, V> node = table[index];

        // 遍历链表，查找对应的 key
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        return null; // 未找到
    }

    // 删除键值对
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        // 遍历链表，查找对应的 key
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next; // 删除头节点
                } else {
                    prev.next = node.next; // 删除中间或尾节点
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    // 获取元素数量
    public int size() {
        return size;
    }

    // 计算键的索引
    private int getIndex(K key) {
        return key.hashCode() % table.length;
    }

    // 扩容哈希表
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2]; // 容量翻倍
        size = 0;

        // 重新哈希所有键值对
        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value); // 重新插入
                node = node.next;
            }
        }
    }

    // 测试
    public static void main(String[] args) {
        MyHashMap1<String, Integer> map = new MyHashMap1<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size()); // 输出: Size: 3
        System.out.println("Get 'two': " + map.get("two")); // 输出: Get 'two': 2

        map.remove("two");
        System.out.println("Size after remove: " + map.size()); // 输出: Size after remove: 2
        System.out.println("Get 'two': " + map.get("two")); // 输出: Get 'two': null
    }
}