package List.Q206;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
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

    public class ReverseLinkedList1 {
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;

        }

        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // 创建一个示例链表 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.println("原始链表:");
            printList(head);

            ListNode reversedHead = reverseList(head);

            System.out.println("反转后的链表:");
            printList(reversedHead);
        //=============
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入链表节点的值，以空格分隔，输入 -1 结束输入：");
//            ListNode dummy = new ListNode(-1);
//            ListNode current = dummy;
//            while (scanner.hasNextInt()) {
//                int num = scanner.nextInt();
//                if (num == -1) {
//                    break;
//                }
//                current.next = new ListNode(num);
//                current = current.next;
//            }
//            scanner.close();
//
//            ListNode head = dummy.next;
//            System.out.println("原始链表:");
//            printList(head);
//
//            ListNode reversedHead = reverseList(head);
//
//            System.out.println("反转后的链表:");
//            printList(reversedHead);

        }
    }
}