package CrackingTheCodingInterview.ch4;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTInorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 情况 1: 如果该结点有右子树，那么中序后继是右子树中的最左结点
        if (node.right != null) {
            return findLeftmost(node.right);
        }
        // 情况 2: 如果该结点没有右子树，向上查找第一个满足当前结点是其父结点左孩子的父结点
        TreeNode parent = node.parent;
        while (parent != null && parent.right == node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private TreeNode findLeftmost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉查找树
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.parent = root;
        root.right = new TreeNode(22);
        root.right.parent = root;
        root.left.left = new TreeNode(4);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(12);
        root.left.right.parent = root.left;
        root.left.right.left = new TreeNode(10);
        root.left.right.left.parent = root.left.right;
        root.left.right.right = new TreeNode(14);
        root.left.right.right.parent = root.left.right;

        BSTInorderSuccessor solution = new BSTInorderSuccessor();
        // 查找结点 8 的中序后继
        TreeNode successor = solution.inorderSuccessor(root.left);
        if (successor != null) {
            System.out.println("结点 8 的中序后继是: " + successor.val);
        } else {
            System.out.println("结点 8 没有中序后继");
        }
    }
}    