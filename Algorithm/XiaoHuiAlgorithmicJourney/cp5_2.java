class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class cp5_2 {
    public int[] detectCycleAndGetLength(ListNode head) {
        if (head == null || head.next == null) {
            return new int[]{0, 0}; // 无环，环长度为 0
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return new int[]{0, 0}; // 无环，环长度为 0
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 快慢指针相遇，说明有环
        ListNode current = slow;
        int cycleLength = 1;
        current = current.next;
        while (current != slow) {
            current = current.next;
            cycleLength++;
        }
        return new int[]{1, cycleLength};
    }

    public static void main(String[] args) {
        // 创建一个有环的链表用于测试
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 创建环

        cp5_2 solution = new cp5_2();
        int[] result = solution.detectCycleAndGetLength(node1);
        if (result[0] == 1) {
            System.out.println("链表有环，环的长度为: " + result[1]);
        } else {
            System.out.println("链表无环");
        }
    }
}