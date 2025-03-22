package CrackingTheCodingInterview.ch2;

public class cp3 {


    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        // 将下一个节点的值赋给当前节点
        node.val = node.next.val;
        // 删除下一个节点
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // 创建一个简单的链表 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode middleNode = new ListNode(3);
        head.next.next = middleNode;
        middleNode.next = new ListNode(4);

        // 删除中间节点 3
        deleteNode(middleNode);

        // 打印链表验证
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
