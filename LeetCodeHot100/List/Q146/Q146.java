package List.Q146;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/28 ÉÏÎç9:52
 */

class doublelinknode {
    int key;
    int value;
    doublelinknode prev;
    doublelinknode next;

    public doublelinknode() {

    }


    public doublelinknode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LruCache {

    private int capacity;
    private int size;
    private Map<Integer, doublelinknode> cache;
    private doublelinknode head;
    private doublelinknode tail;

    LruCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new doublelinknode();
        tail = new doublelinknode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        doublelinknode doublelinknode = cache.get(key);
        if (doublelinknode == null) {
            return -1;
        }
        moveToHead(doublelinknode);
        return doublelinknode.value;


    }

    public void put(int key, int value) {
        doublelinknode node = cache.get(key);
        if (node == null) {
            doublelinknode newNode = new doublelinknode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                doublelinknode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(doublelinknode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(doublelinknode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(doublelinknode node) {
        removeNode(node);
        addToHead(node);
    }

    private doublelinknode removeTail() {
        doublelinknode removed = tail.prev;
        removeNode(removed);
        return removed;
    }
}









