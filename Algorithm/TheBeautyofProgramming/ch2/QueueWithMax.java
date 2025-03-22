package TheBeautyofProgramming.ch2;

import java.util.LinkedList;

class QueueWithMax {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> maxQueue;

    public QueueWithMax() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    // 将 v 加入队列中
    public void enQueue(int v) {
        queue.addLast(v);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < v) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(v);
    }

    // 使队列中的队首元素删除并返回此元素
    public int deQueue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int front = queue.removeFirst();
        if (front == maxQueue.getFirst()) {
            maxQueue.removeFirst();
        }
        return front;
    }

    // 返回队列中的最大元素
    public int maxElement() {
        if (maxQueue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return maxQueue.getFirst();
    }

    public static void main(String[] args) {
        QueueWithMax queue = new QueueWithMax();
        queue.enQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println("Max element: " + queue.maxElement());
        System.out.println("Dequeued element: " + queue.deQueue());
        System.out.println("Max element after dequeue: " + queue.maxElement());
    }
}    