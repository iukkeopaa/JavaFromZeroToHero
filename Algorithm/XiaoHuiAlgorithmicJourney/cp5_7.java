package XiaoHuiAlgorithmicJourney;

import java.util.Stack;

class cp5_7 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public cp5_7() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }
}

class Main {
    public static void main(String[] args) {
        cp5_7 queue = new cp5_7();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
