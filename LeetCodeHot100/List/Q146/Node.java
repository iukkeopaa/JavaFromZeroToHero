package List.Q146;

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache12 {
    private int capacity;
    private Node head;
    private int size;

    public LRUCache12(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.size = 0;
    }

    private void removeHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    private void moveToTail(int key) {
        Node dummy = new Node(0, 0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
            current.next = null;
            Node tail = dummy;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = current;
            head = dummy.next;
        }
    }

    public int get(int key) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                if (prev != null) {
                    prev.next = current.next;
                    Node tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = current;
                    current.next = null;
                }
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                if (prev != null) {
                    prev.next = current.next;
                    Node tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = current;
                    current.next = null;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
        Node newNode = new Node(key, value);
        if (size == capacity) {
            removeHead();
        }
        if (head == null) {
            head = newNode;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }
        size++;
    }
}    