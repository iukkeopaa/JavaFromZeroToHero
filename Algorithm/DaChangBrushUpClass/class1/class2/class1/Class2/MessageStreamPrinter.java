package DaChangBrushUpClass.class1.class2.class1.Class2;

import java.util.HashMap;
import java.util.TreeSet;

//已知一个消息流会不断地吐出整数1~N，但不一定按照顺序依次吐出，如果上次打印的序号为i， 那么当i+1出现时
//请打印i+1及其之后接收过的并且连续的所有数，直到1~N全部接收并打印完，请设计这种接收并打印的结构


//思路
//1.使用一个变量nextToPrint记录下一个需要打印的序号，初始值为1
//2.使用一个TreeSet集合receivedNumbers记录已经接收过的序号
//3.当一个序号num出现时，将num加入receivedNumbers集合
public class MessageStreamPrinter {
    private int nextToPrint;
    private TreeSet<Integer> receivedNumbers;
    private int N;

    public MessageStreamPrinter(int N) {
        this.nextToPrint = 1;
        this.receivedNumbers = new TreeSet<>();
        this.N = N;
    }

    public void receive(int num) {
        if (num >= 1 && num <= N) {
            receivedNumbers.add(num);
            printContinuousNumbers();
        }
    }

    private void printContinuousNumbers() {
        while (!receivedNumbers.isEmpty() && receivedNumbers.first() == nextToPrint) {
            int num = receivedNumbers.pollFirst();
            System.out.println(num);
            nextToPrint++;
        }
    }


    public static class Node {
        public String info;
        public Node next;

        public Node(String str) {
            info = str;
        }
    }

    public static class MessageBox {
        private HashMap<Integer, Node> headMap;
        private HashMap<Integer, Node> tailMap;
        private int waitPoint;

        public MessageBox() {
            headMap = new HashMap<Integer, Node>();
            tailMap = new HashMap<Integer, Node>();
            waitPoint = 1;
        }

        // 消息的编号，info消息的内容, 消息一定从1开始
        public void receive(int num, String info) {
            if (num < 1) {
                return;
            }
            Node cur = new Node(info);
            // num~num
            headMap.put(num, cur);
            tailMap.put(num, cur);
            // 建立了num~num这个连续区间的头和尾
            // 查询有没有某个连续区间以num-1结尾
            if (tailMap.containsKey(num - 1)) {
                tailMap.get(num - 1).next = cur;
                tailMap.remove(num - 1);
                headMap.remove(num);
            }
            // 查询有没有某个连续区间以num+1开头的
            if (headMap.containsKey(num + 1)) {
                cur.next = headMap.get(num + 1);
                tailMap.remove(num);
                headMap.remove(num + 1);
            }
            if (num == waitPoint) {
                print();
            }
        }

        private void print() {
            Node node = headMap.get(waitPoint);
            headMap.remove(waitPoint);
            while (node != null) {
                System.out.print(node.info + " ");
                node = node.next;
                waitPoint++;
            }
            tailMap.remove(waitPoint-1);
            System.out.println();
        }

    }
    public static void main(String[] args) {
        MessageStreamPrinter printer = new MessageStreamPrinter(10);
        int[] messageStream = {3, 1, 2, 5, 4, 7, 6, 8, 10, 9};
        for (int num : messageStream) {
            printer.receive(num);
        }


        MessageBox box = new MessageBox();
        // 1....
        System.out.println("这是2来到的时候");
        box.receive(2,"B"); // - 2"
        System.out.println("这是1来到的时候");
        box.receive(1,"A"); // 1 2 -> print, trigger is 1
        box.receive(4,"D"); // - 4
        box.receive(5,"E"); // - 4 5
        box.receive(7,"G"); // - 4 5 - 7
        box.receive(8,"H"); // - 4 5 - 7 8
        box.receive(6,"F"); // - 4 5 6 7 8
        box.receive(3,"C"); // 3 4 5 6 7 8 -> print, trigger is 3
        box.receive(9,"I"); // 9 -> print, trigger is 9
        box.receive(10,"J"); // 10 -> print, trigger is 10
        box.receive(12,"L"); // - 12
        box.receive(13,"M"); // - 12 13
        box.receive(11,"K"); // 11 12 13 -> print, trigger is 11

    }
}    