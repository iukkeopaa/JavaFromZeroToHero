package CrackingTheCodingInterview.ch2;

public class cp4 { public static ListNode partition(ListNode head, int x) {
    // 创建两个虚拟头结点，分别用于存储小于 x 和大于等于 x 的节点
    ListNode beforeHead = new ListNode(0);
    ListNode before = beforeHead;
    ListNode afterHead = new ListNode(0);
    ListNode after = afterHead;

    while (head != null) {
        if (head.val < x) {
            before.next = head;
            before = before.next;
        } else {
            after.next = head;
            after = after.next;
        }
        head = head.next;
    }

    // 断开 after 链表的末尾
    after.next = null;
    // 连接两个链表
    before.next = afterHead.next;

    return beforeHead.next;
}

    public static void main(String[] args) {
        // 创建链表 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        ListNode partitionedHead = partition(head, x);

        // 打印分割后的链表
        while (partitionedHead != null) {
            System.out.print(partitionedHead.val + " ");
            partitionedHead = partitionedHead.next;
        }
    }
}
