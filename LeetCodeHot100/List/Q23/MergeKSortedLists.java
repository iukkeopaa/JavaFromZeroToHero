package List.Q23;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists212(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 创建最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将所有链表的头节点加入最小堆
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 不断从最小堆中取出最小节点，并将其下一个节点加入堆中
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    private ListNode mergeTwoLists123(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    // 两两合并多个有序链表的方法
    public ListNode mergeKLists321(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            ListNode[] newLists = new ListNode[(lists.length + 1) / 2];
            int index = 0;
            for (int i = 0; i < lists.length; i += 2) {
                if (i + 1 < lists.length) {
                    newLists[index++] = mergeTwoLists(lists[i], lists[i + 1]);
                } else {
                    newLists[index++] = lists[i];
                }
            }
            lists = newLists;
        }

        return lists[0];
    }
    public static void main(String[] args) {
        // 创建示例链表
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode mergedList = solution.mergeKLists(lists);

        // 输出合并后的链表
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}    