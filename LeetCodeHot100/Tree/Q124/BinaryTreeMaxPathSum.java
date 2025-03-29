package Tree.Q124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子树
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("最大路径和: " + maxPathSum);
    }
}    