package CrackingTheCodingInterview.ch3;

import java.util.Stack;

class SortedStack {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public SortedStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int val) {
        // 当栈不为空且栈顶元素小于要插入的值时
        while (!stack.isEmpty() && stack.peek() < val) {
            tempStack.push(stack.pop());
        }
        // 将值插入到合适的位置
        stack.push(val);
        // 将临时栈中的元素再放回原栈
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(3);
        sortedStack.push(1);
        sortedStack.push(2);
        // 依次输出栈顶元素，应为 3 2 1
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.peek());
            sortedStack.pop();
        }
    }
}    