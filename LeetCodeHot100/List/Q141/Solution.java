package List.Q141;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            // 指向空节点则无环
            if (fast == null || fast.next == null) 
                return false;

            // fast 和 slow 异速前进
            fast = fast.next.next;
            slow = slow.next;

            // 相遇
            if (slow == fast) return true;
        }
    }
}
