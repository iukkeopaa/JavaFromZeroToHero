package List.Q25;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

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

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) return null;
        // 找到第 k 个节点
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个节点，不进行翻转
            if (b == null) return head;
            b = b.next;
        }
        // 翻转 [a, b) 区间的节点
        ListNode newHead = reverse1(a, b);
        // 递归翻转后续链表
        a.next = reverseKGroup1(b, k);
        return newHead;
    }

    // 翻转 [a, b) 区间的节点
    private ListNode reverse1(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public ListNode reverseKGroup12(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // 将 k 个节点压入栈中
            for (int i = 0; i < k && current != null; i++) {
                stack.push(current);
                current = current.next;
            }
            // 如果栈中节点数量不足 k 个，则不进行翻转
            if (stack.size() < k) {
                break;
            }
            // 依次弹出栈中节点，连接成新的链表
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
            // 连接剩余链表
            prev.next = current;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup233(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (true) {
            // 找到当前组的第 k 个节点
            ListNode kthNode = findKthNode(prevGroupTail, k);
            if (kthNode == null) {
                break;
            }
            ListNode nextGroupHead = kthNode.next;

            // 记录当前组的第一个节点，翻转后它会成为该组的最后一个节点
            ListNode currentGroupFirst = prevGroupTail.next;
            // 尾插法翻转当前组的 k 个节点
            while (prevGroupTail.next != nextGroupHead) {
                ListNode temp = prevGroupTail.next;
                prevGroupTail.next = temp.next;
                temp.next = kthNode.next;
                kthNode.next = temp;
            }

            // 更新 prevGroupTail 指向下一组的前一个节点
            prevGroupTail = currentGroupFirst;
        }
        return dummy.next;
    }

    // 找到从 start 开始的第 k 个节点
    private ListNode findKthNode(ListNode start, int k) {
        ListNode current = start;
        for (int i = 0; i < k; i++) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        return current;
    }
    public static void main(String[] args) {
        // 创建链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        // 打印结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}