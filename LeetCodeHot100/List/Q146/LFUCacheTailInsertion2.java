package List.Q146;

import java.util.HashMap;
import java.util.Map;

class LFUCacheTailInsertion2 {
    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        int size;

        DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeFirst() {
            if (size > 0) {
                Node first = head.next;
                remove(first);
                return first;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoubleLinkedList> freqToList;

    public LFUCacheTailInsertion2(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        increaseFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.val = value;
            increaseFreq(node);
            return;
        }
        if (keyToNode.size() == capacity) {
            removeMinFreqKey();
        }
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        freqToList.putIfAbsent(1, new DoubleLinkedList());
        freqToList.get(1).addLast(newNode);
        this.minFreq = 1;
    }

    private void increaseFreq(Node node) {
        int freq = node.freq;
        freqToList.get(freq).remove(node);
        if (freqToList.get(freq).size == 0) {
            freqToList.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
        node.freq++;
        freqToList.putIfAbsent(node.freq, new DoubleLinkedList());
        freqToList.get(node.freq).addLast(node);
    }

    private void removeMinFreqKey() {
        DoubleLinkedList list = freqToList.get(this.minFreq);
        Node deletedNode = list.removeFirst();
        keyToNode.remove(deletedNode.key);
    }
}