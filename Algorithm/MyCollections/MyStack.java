package MyCollections.FindSubtreeNodes;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 入栈操作
    public void push(int x) {
        // 哪个队列有元素就加到哪个队列
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    // 出栈操作
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        // 将非空队列中除最后一个元素外的元素转移到空队列
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.poll());
        }
        return nonEmptyQueue.poll();
    }

    // 获取栈顶元素
    public int top() {
        int top = pop();
        push(top);
        return top;
    }

    // 判断栈是否为空
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); 
        System.out.println(stack.pop()); 
        System.out.println(stack.empty()); 
    }
}