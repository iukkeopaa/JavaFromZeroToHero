package CrackingTheCodingInterview.ch3;

import java.util.ArrayList;
import java.util.Stack;

class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks;
    private int capacity;

    public SetOfStacks(int capacity) {
        this.stacks = new ArrayList<>();
        this.capacity = capacity;
    }

    public void push(int value) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        } else {
            stacks.get(stacks.size() - 1).push(value);
        }
    }

    public int pop() {
        if (stacks.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
        int value = lastStack.pop();
        if (lastStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Stack<Integer> targetStack = stacks.get(index);
        if (targetStack.isEmpty()) {
            throw new IllegalStateException("Sub - stack at index " + index + " is empty");
        }
        int poppedValue = targetStack.pop();
        if (targetStack.isEmpty()) {
            stacks.remove(index);
        }
        return poppedValue;
    }

    public boolean isEmpty() {
        return stacks.isEmpty();
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.popAt(0));
    }
}
    