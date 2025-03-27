package List.Q160;

import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FindIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    //从后往前找 用栈
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Deque<ListNode> s1 = new ArrayDeque<ListNode>(), s2 = new ArrayDeque<ListNode>();
        for (ListNode p = headA; p != null; p = p.next)
            s1.addLast(p);
        for (ListNode p = headB; p != null; p = p.next)
            s2.addLast(p);
        ListNode ans = null;
        while (!s1.isEmpty() && !s2.isEmpty() && s1.peekLast() == s2.peekLast()) {
            s1.pollLast();
            ans = s2.pollLast();
        }
        return ans;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int s1 = 0, s2 = 0;
        for (ListNode p = headA; p != null; p = p.next) ++s1;
        for (ListNode p = headB; p != null; p = p.next) ++s2;
        ListNode p = headA, q = headB;
        while (s1 < s2) {
            q = q.next;
            --s2;
        }
        while (s1 > s2) {
            p = p.next;
            --s1;
        }
        while (p != null && q != null) {
            if (p == q)
                return p;
            p = p.next; q = q.next;
        }
        return null;
    }




}    