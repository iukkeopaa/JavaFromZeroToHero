package List.Q24;

import java.util.Stack;

// 定义链表节点类
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesInPairs {
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 交换节点
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 移动指针
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    // 辅助方法：将数组转换为链表
    public static ListNode arrayToList(int[] arr) {
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

    // 辅助方法：将链表转换为字符串以便输出
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }


//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0, head); // 用哨兵节点简化代码逻辑
//        ListNode node0 = dummy;
//        ListNode node1 = head;
//        while (node1 != null && node1.next != null) { // 至少有两个节点
//            ListNode node2 = node1.next;
//            ListNode node3 = node2.next;
//
//            node0.next = node2; // 0 -> 2
//            node2.next = node1; // 2 -> 1
//            node1.next = node3; // 1 -> 3
//
//            node0 = node1; // 下一轮交换，0 是 1
//            node1 = node3; // 下一轮交换，1 是 3
//        }
//        return dummy.next; // 返回新链表的头节点
//    }
    public ListNode swapPairs4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = node2.next;

        node1.next = swapPairs4(node3); // 1 指向递归返回的链表头
        node2.next = node1; // 2 指向 1

        return node2; // 返回交换后的链表头节点
    }

    public ListNode swapPairs123(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        //用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //head指向新的p节点，函数结束时返回head.next即可
        head = p;
        while(cur!=null && cur.next!=null) {
            //将两个节点放入stack中
            stack.add(cur);
            stack.add(cur.next);
            //当前节点往前走两步
            cur = cur.next.next;
            //从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件，当链表长度是奇数时，cur就不为空
        if(cur!=null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
    }




    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = arrayToList(arr);
        System.out.println("原始链表: " + listToString(head));

        ListNode swappedHead = swapPairs1(head);
        System.out.println("交换后的链表: " + listToString(swappedHead));
    }
}    