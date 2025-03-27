package List.Q234;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


//快慢指针
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
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

        // 反转链表的后半部分
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


    //list和array的转换
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        java.util.ArrayList<Integer> arr = new java.util.ArrayList<Integer>();
        //申请一个容器，然后把元素都放到数组中
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = arr.size() - 1;
        //用i和j两个指针，一个往后，一个往前，不断迭代
        //如果i的值不等于j说明不是回文，反之是回文
        while (i < j) {
            if (arr.get(i).compareTo(arr.get(j)) != 0) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    //使用栈
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        // 第一次遍历链表，将节点值压入栈中
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        current = head;
        // 第二次遍历链表，将节点值与栈中弹出的值比较
        while (current != null) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }
        return true;
    }


    public class PalindromeLinkedListRecursive {
        private ListNode frontPointer;

        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
        }

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) {
                    return false;
                }
                if (currentNode.val != frontPointer.val) {
                    return false;
                }
                frontPointer = frontPointer.next;
            }
            return true;
        }

        ListNode temp;
        private boolean check(ListNode head) {
            if (head == null)
                return true;
            boolean res = check(head.next) && (temp.val == head.val);
            temp = temp.next;
            return res;
        }


        public static void main(String[] args) {
            PalindromeLinkedList solution = new PalindromeLinkedList();
            // 创建链表 1 -> 2 -> 2 -> 1
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);

            boolean result = solution.isPalindrome(head);
            System.out.println("该链表是否为回文链表: " + result);
        }
    }
}