package BloomFilter;

import java.util.BitSet;

public class BloomFilter {
    // 布隆过滤器的位数组
    private BitSet bitSet;
    // 位数组的大小
    private int size;
    // 哈希函数的数量
    private int hashCount;

    public BloomFilter(int size, int hashCount) {
        this.size = size;
        this.hashCount = hashCount;
        this.bitSet = new BitSet(size);
    }

    // 添加元素到布隆过滤器
    public void add(String element) {
        for (int i = 0; i < hashCount; i++) {
            int hash = hash(element, i);
            bitSet.set(hash);
        }
    }

    // 判断元素是否可能存在于布隆过滤器中
    public boolean mightContain(String element) {
        for (int i = 0; i < hashCount; i++) {
            int hash = hash(element, i);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    // 自定义哈希函数
    private int hash(String element, int seed) {
        int hash = 0;
        for (int i = 0; i < element.length(); i++) {
            hash = (seed * hash) + element.charAt(i);
        }
        return Math.abs(hash) % size;
    }

    public static void main(String[] args) {
        // 创建一个布隆过滤器，位数组大小为 1000，哈希函数数量为 3
        BloomFilter bloomFilter = new BloomFilter(1000, 3);

        // 添加元素
        bloomFilter.add("apple");
        bloomFilter.add("banana");

        // 判断元素是否可能存在
        System.out.println(bloomFilter.mightContain("apple")); // 输出: true
        System.out.println(bloomFilter.mightContain("cherry")); // 输出: false
    }
}