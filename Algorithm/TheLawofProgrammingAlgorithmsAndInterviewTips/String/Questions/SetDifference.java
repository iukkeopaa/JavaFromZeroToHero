package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

// 定义链表节点类
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 定义链表操作类
class LinkedList {
    // 插入节点到链表尾部
    public Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // 计算两个集合的差集
    public Node difference(Node headA, Node headB) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        Node currentA = headA;
        while (currentA != null) {
            boolean found = false;
            Node currentB = headB;
            while (currentB != null) {
                if (currentA.data == currentB.data) {
                    found = true;
                    break;
                }
                currentB = currentB.next;
            }
            if (!found) {
                tail.next = new Node(currentA.data);
                tail = tail.next;
            }
            currentA = currentA.next;
        }
        return dummy.next;
    }

    // 打印链表
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class SetDifference {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // 初始化集合 A
        Node headA = null;
        headA = list.insert(headA, 5);
        headA = list.insert(headA, 10);
        headA = list.insert(headA, 20);
        headA = list.insert(headA, 15);
        headA = list.insert(headA, 25);
        headA = list.insert(headA, 30);

        // 初始化集合 B
        Node headB = null;
        headB = list.insert(headB, 5);
        headB = list.insert(headB, 15);
        headB = list.insert(headB, 35);
        headB = list.insert(headB, 25);

        // 计算差集
        Node result = list.difference(headA, headB);

        // 打印结果
        System.out.print("集合 A 与集合 B 的差集为: ");
        list.printList(result);
    }
}    