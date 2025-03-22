package CrackingTheCodingInterview.ch2;

public class cp7 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 第一步：使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 第二步：反转链表的后半部分
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;
        // 第三步：比较前半部分和反转后的后半部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // 反转链表的方法
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // 构建一个测试链表 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        cp7 solution = new cp7();
        boolean result = solution.isPalindrome(head);
        System.out.println("链表是否为回文: " + result);
    }
}
