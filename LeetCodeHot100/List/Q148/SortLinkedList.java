package List.Q148;

// 定义链表节点类
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 切断链表
        prev.next = null;

        // 递归地对左右两部分进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 合并两个有序链表
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }


    public ListNode sortList123(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到链表的中间节点
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        // 切断链表
        mid.next = null;

        // 递归地对左右两部分进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两个有序链表
        return merge(left, right);
    }

    // 获取链表的中间节点
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode merge123(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // 创建一个示例链表 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortLinkedList solution = new SortLinkedList();
        ListNode sortedList = solution.sortList(head);

        // 输出排序后的链表
        while (sortedList != null) {
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }
}    