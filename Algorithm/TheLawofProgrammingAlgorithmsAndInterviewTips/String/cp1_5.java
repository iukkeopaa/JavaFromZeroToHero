package TheLawofProgrammingAlgorithmsAndInterviewTips.String;

import java.util.Stack;

public class cp1_5 {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "radar";
        String test2 = "hello";
        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//判断一条单向链表是不是回文。
class LinkedListPalindromeChecker {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;
        // 比较前半部分和反转后的后半部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
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
        // 创建一个回文链表 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

        // 创建一个非回文链表 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println(isPalindrome(head2));
    }
}

//判断一个栈是不是回文。



 class PalindromeStack {
    public static boolean isPalindrome(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return true;
        }
        Stack<Character> tempStack = new Stack<>();
        StringBuilder original = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = stack.pop();
            original.append(c);
            tempStack.push(c);
        }

        while (!tempStack.isEmpty()) {
            char c = tempStack.pop();
            reversed.append(c);
            stack.push(c);
        }

        return original.toString().equals(reversed.toString());
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('a');
        System.out.println("该栈是否为回文: " + isPalindrome(stack));
    }
}