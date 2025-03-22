package CrackingTheCodingInterview.ch4;

// 定义二叉树节点类

public class CheckBalancedTree {
    // 用于检查二叉树是否平衡的函数
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 计算树的高度，若树不平衡则返回 -1
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左子树的高度
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        // 递归计算右子树的高度
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 检查左右子树高度差是否超过 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        CheckBalancedTree solution = new CheckBalancedTree();
        boolean result = solution.isBalanced(root);
        System.out.println("这棵二叉树是否平衡: " + result);
    }
}    