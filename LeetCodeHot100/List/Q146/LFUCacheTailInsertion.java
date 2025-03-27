package List.Q146;

class LFUCacheTailInsertion {
    private class Node {
        int key;
        int value;
        int freq;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LFUCacheTailInsertion(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                int value = curr.value;
                curr.freq++;
                // 移除当前节点
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
                if (curr == tail) {
                    tail = prev;
                }
                // 尾插法插入节点
                insertNodeAtTail(curr);
                return value;
            }
            prev = curr;
            curr = curr.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                curr.freq++;
                // 移除当前节点
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
                if (curr == tail) {
                    tail = prev;
                }
                // 尾插法插入节点
                insertNodeAtTail(curr);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        // 键不存在，插入新节点
        if (size == capacity) {
            // 移除最不经常使用的节点（即链表头部节点）
            if (head == null) {
                return;
            }
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
        }
        Node newNode = new Node(key, value);
        insertNodeAtTail(newNode);
        size++;
    }

    private void insertNodeAtTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = null;
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.freq <= node.freq) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            node.next = head;
            head = node;
            if (tail == null) {
                tail = node;
            }
        } else {
            prev.next = node;
            node.next = curr;
            if (curr == null) {
                tail = node;
            }
        }
    }
}    