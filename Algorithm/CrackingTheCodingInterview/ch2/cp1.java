package CrackingTheCodingInterview.ch2;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class cp1 {
    private static class LinkedListNode {
        int data;
        LinkedListNode next;
    }

    /**
     * 解法
     * 要想移除链表中的重复结点，我们需要设法记录有哪些是重复的。这里只要用到一个简单的
     * 散列表。
     * 在下面的解法中，我们会直接迭代访问整个链表，将每个结点加入散列表。若发现有重复元
     * 素，则将该结点从链表中移除，然后继续迭代。
     * 代码的时间复杂度为O(N) ，其中N为链表结点数目。
     *
     * @param n
     */
    public static void deleteDups(LinkedListNode n) {
        Set<LinkedListNode> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n)) {
                previous.next = n.next;
            } else {
                set.add(n);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * 进阶： 不得使用缓冲区
     * 如不借助额外的缓冲区，可以用两个指针来迭代： current迭代访问整个链表，runner用于
     * 检查后续的结点是否重复。
     *
     * @param head
     */
    public static void deleteDups2(LinkedListNode head) {
        if (head == null) {
            return;
        }

        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current.next;
            while (runner.next != null) {
                // 如果有相同的就去掉重复节点
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    // 不相同就移动到下一个节点
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }


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

    public static void main(String[] args) {
        // 构建一个简单的链表用于测试 1 -> 2 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        cp1 solution = new cp1();
        ListNode result = solution.removeDuplicates(head);

        // 输出结果链表
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
