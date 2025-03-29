package Tree.Q94;

import java.util.*;

// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> inorderTraversal1123(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null ||!stack.isEmpty()) {
            // 先将左子树节点全部入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 取出栈顶节点
            current = stack.pop();
            result.add(current.val);
            // 转向右子树
            current = current.right;
        }
        return result;
    }




    //颜色标记法
    class Node {
        TreeNode node;
        int color;

        Node(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal6(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if(root == null) return ans;
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.node == null) continue;
            if (cur.color == 1) {
                stack.push(new Node(cur.node.right, 1));
                stack.push(new Node(cur.node, 2));
                stack.push(new Node(cur.node.left, 1));
            } else {
                ans.add(cur.node.val);
            }
        }
        return ans;
    }
public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
    }
}    