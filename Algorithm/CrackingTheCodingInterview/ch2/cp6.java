package CrackingTheCodingInterview.ch2;

public class cp6 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 慢指针回到头节点，快慢指针同速移动，再次相遇处即为环的入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // 创建一个有环链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        cp6 solution = new cp6();
        ListNode loopStart = solution.detectCycle(node1);
        if (loopStart != null) {
            System.out.println("环路的开头结点值为: " + loopStart.val);
        } else {
            System.out.println("链表中没有环");
        }
    }
}
