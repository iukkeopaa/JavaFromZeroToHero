package Tree.Q98;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution2 {
        public int kthSmallest(TreeNode root, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
            Deque<TreeNode> d = new ArrayDeque<>();
            d.addLast(root);
            while (!d.isEmpty()) {
                TreeNode node = d.pollFirst();
                if (q.size() < k) {
                    q.add(node.val);
                } else if (q.peek() > node.val) {
                    q.poll();
                    q.add(node.val);
                }
                if (node.left != null) d.addLast(node.left);
                if (node.right != null) d.addLast(node.right);
            }
            return q.peek();
        }
    }