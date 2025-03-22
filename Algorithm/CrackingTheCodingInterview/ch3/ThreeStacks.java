package CrackingTheCodingInterview.ch3;

class ThreeStacks {
    private int[] array;
    private int[] tops;
    private int stackSize;

    public ThreeStacks(int stackSize) {
        this.stackSize = stackSize;
        array = new int[stackSize * 3];
        tops = new int[3];
        tops[0] = -1;
        tops[1] = stackSize - 1;
        tops[2] = 2 * stackSize - 1;
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("Stack " + stackNum + " is full.");
            return;
        }
        tops[stackNum]++;
        array[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack " + stackNum + " is empty.");
            return -1;
        }
        int value = array[indexOfTop(stackNum)];
        tops[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack " + stackNum + " is empty.");
            return -1;
        }
        return array[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return tops[stackNum] == (stackNum * stackSize) - 1;
    }

    public boolean isFull(int stackNum) {
        return tops[stackNum] == (stackNum + 1) * stackSize - 1;
    }

    private int indexOfTop(int stackNum) {
        return tops[stackNum];
    }
}