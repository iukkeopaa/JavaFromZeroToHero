package StakcAndQueue;

// 环形数组实现栈
class CircularArrayStack {
    private int[] array;
    private int top;
    private int capacity;

    public CircularArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top + 1) % capacity == 0;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full, cannot push " + item);
            return;
        }
        top = (top + 1) % capacity;
        array[top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int item = array[top];
        top = (top - 1 + capacity) % capacity;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return -1;
        }
        return array[top];
    }
}

// 环形数组实现队列
class CircularArrayQueue {
    private int[] array;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return -1;
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot peek");
            return -1;
        }
        return array[front];
    }
}

public class Main {
    public static void main(String[] args) {
        // 测试栈
        CircularArrayStack stack = new CircularArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack peek after pop: " + stack.peek());

        // 测试队列
        CircularArrayQueue queue = new CircularArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue peek after dequeue: " + queue.peek());
    }
}    