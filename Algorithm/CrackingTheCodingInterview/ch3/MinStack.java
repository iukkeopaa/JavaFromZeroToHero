package CrackingTheCodingInterview.ch3;

import java.util.Stack;

class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        System.out.println("当前最小值: " + stack.min()); 
        stack.pop();
        System.out.println("当前最小值: " + stack.min()); 
    }
}    