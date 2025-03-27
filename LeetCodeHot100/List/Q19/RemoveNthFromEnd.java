package List.Q19;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head1, int n) {

        int count=0;
        if (head1 == null) {
            return null;
        }
        head1.next = removeNthFromEnd(head1.next, n);
        count++;
        if (count == n) {
            return head1.next;
        }
        return head1;
    }
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        int pos = length(head, n);
        // 说明删除的是头节点
        if (pos == n)
            return head.next;
        return head;
    }

    // 获取节点所在位置，逆序
    public int length(ListNode node, int n) {
        if (node == null)
            return 0;
        int pos = length(node.next, n) + 1;
        //获取要删除链表的前一个结点，就可以完成链表的删除
        if (pos == n + 1)
            node.next = node.next.next;
        return pos;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = createList(arr);
        System.out.println("Original list:");
        printList(head);

        ListNode newHead = removeNthFromEnd1(head, n);

        System.out.println("List after removing the " + n + "th node from the end:");
        printList(newHead);
    }
}