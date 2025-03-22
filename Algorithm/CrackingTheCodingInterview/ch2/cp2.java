package CrackingTheCodingInterview.ch2;



public class cp2 {


    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        java.util.HashSet<Integer> values = new java.util.HashSet<>();
        values.add(head.val);
        ListNode current = head;
        while (current.next != null) {
            if (values.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                values.add(current.next.val);
                current = current.next;
            }
        }
        return head;
    }

    public ListNode findKthToLast(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        // 让 first 指针先走 k 步
        for (int i = 0; i < k; i++) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }
        // 然后 first 和 second 指针同时移动，直到 first 指针到达链表末尾
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        // 构建一个简单的链表用于测试 1 -> 2 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        cp2 solution = new cp2();
        ListNode result = solution.removeDuplicates(head);

        // 输出结果链表
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        // 测试找出倒数第 k 个结点
        int k = 2;
        ListNode kthToLast = solution.findKthToLast(head, k);
        if (kthToLast != null) {
            System.out.println("\n倒数第 " + k + " 个结点的值是: " + kthToLast.val);
        } else {
            System.out.println("\n未找到倒数第 " + k + " 个结点。");
        }
    }
}
