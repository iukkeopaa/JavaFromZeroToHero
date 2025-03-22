package ConcurrentSecurityList;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;


class ConcurrentLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public synchronized void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public synchronized boolean remove(T data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public synchronized boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
class ConcurrentLinkedListWithLock<T> {
    private Node<T> head;
    private final ReentrantLock lock = new ReentrantLock();

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        lock.lock();
        try {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T data) {
        lock.lock();
        try {
            if (head == null) {
                return false;
            }
            if (head.data.equals(data)) {
                head = head.next;
                return true;
            }
            Node<T> current = head;
            while (current.next != null) {
                if (current.next.data.equals(data)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean contains(T data) {
        lock.lock();
        try {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}



class ConcurrentLinkedListWithLock2<T> {
    private Node<T> head;
    private final ReentrantLock lock = new ReentrantLock();

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        lock.lock();
        try {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T data) {
        lock.lock();
        try {
            if (head == null) {
                return false;
            }
            if (head.data.equals(data)) {
                head = head.next;
                return true;
            }
            Node<T> current = head;
            while (current.next != null) {
                if (current.next.data.equals(data)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean contains(T data) {
        lock.lock();
        try {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}



class ConcurrentLinkedListCAS<T> {
    private AtomicReference<Node<T>> head = new AtomicReference<>(null);

    private static class Node<T> {
        T data;
        AtomicReference<Node<T>> next;

        Node(T data) {
            this.data = data;
            this.next = new AtomicReference<>(null);
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        while (true) {
            Node<T> currentHead = head.get();
            newNode.next.set(currentHead);
            if (head.compareAndSet(currentHead, newNode)) {
                break;
            }
        }
    }

    public boolean remove(T data) {
        while (true) {
            Node<T> currentHead = head.get();
            if (currentHead == null) {
                return false;
            }
            if (currentHead.data.equals(data)) {
                if (head.compareAndSet(currentHead, currentHead.next.get())) {
                    return true;
                }
            } else {
                Node<T> current = currentHead;
                while (current.next.get() != null) {
                    Node<T> nextNode = current.next.get();
                    if (nextNode.data.equals(data)) {
                        if (current.next.compareAndSet(nextNode, nextNode.next.get())) {
                            return true;
                        }
                        break;
                    }
                    current = nextNode;
                }
                return false;
            }
        }
    }

    public boolean contains(T data) {
        Node<T> current = head.get();
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next.get();
        }
        return false;
    }
}