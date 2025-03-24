package MyCollections.FindSubtreeNodes;

//给定一个单向链表，向右循环旋转 k 次，返回新的链表头，要求时间复杂度 O(n)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        RotateLinkedList solution = new RotateLinkedList();
        ListNode result = solution.rotateRight(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}    