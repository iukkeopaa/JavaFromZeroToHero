package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;

// 定义二叉树节点类


public class BinaryTreeMaxDistance {
    // 定义一个类变量来存储最大距离
    private static int maxDistance = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDistance;
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左子树的深度
        int leftDepth = depth(node.left);
        // 递归计算右子树的深度
        int rightDepth = depth(node.right);
        // 更新最大距离
        maxDistance = Math.max(maxDistance, leftDepth + rightDepth);
        // 返回当前节点的最大深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 计算最大距离
        int distance = diameterOfBinaryTree(root);
        System.out.println("二叉树中相距最远的两个结点之间的距离是: " + distance);
    }
}    