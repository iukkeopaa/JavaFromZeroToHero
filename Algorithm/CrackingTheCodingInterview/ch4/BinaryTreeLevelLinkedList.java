package CrackingTheCodingInterview.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 定义二叉树节点类

// 定义链表节点类


public class BinaryTreeLevelLinkedList {
    public static ArrayList<ListNode> createLevelLinkedList(TreeNode root) {
        ArrayList<ListNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                current.next = new ListNode(node.val);
                current = current.next;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(dummy.next);
        }

        return result;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<ListNode> lists = createLevelLinkedList(root);

        // 打印每个链表
        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}    