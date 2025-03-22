package MyCollections.FindSubtreeNodes.BalancedBinaryTree;

// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BalancedBinaryTree {

    // 方法一：自顶向下的递归方法
    public boolean isBalancedTopDown(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 计算左右子树的高度
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 检查当前节点的左右子树高度差是否不超过 1，并且递归检查左右子树是否平衡
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    // 计算树的高度
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 方法二：自底向上的递归方法
    public boolean isBalancedBottomUp(TreeNode root) {
        return heightCheck(root) != -1;
    }

    // 计算树的高度并检查是否平衡
    private int heightCheck(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左子树的高度
        int leftHeight = heightCheck(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        // 递归计算右子树的高度
        int rightHeight = heightCheck(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 检查当前节点的左右子树高度差是否超过 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // 构建一个平衡二叉树
        TreeNode balancedRoot = new TreeNode(1);
        balancedRoot.left = new TreeNode(2);
        balancedRoot.right = new TreeNode(3);
        balancedRoot.left.left = new TreeNode(4);
        balancedRoot.left.right = new TreeNode(5);

        // 构建一个非平衡二叉树
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);
        unbalancedRoot.left.left.left = new TreeNode(4);

        // 测试自顶向下的方法
        System.out.println("自顶向下方法 - 平衡二叉树: " + solution.isBalancedTopDown(balancedRoot));
        System.out.println("自顶向下方法 - 非平衡二叉树: " + solution.isBalancedTopDown(unbalancedRoot));

        // 测试自底向上的方法
        System.out.println("自底向上方法 - 平衡二叉树: " + solution.isBalancedBottomUp(balancedRoot));
        System.out.println("自底向上方法 - 非平衡二叉树: " + solution.isBalancedBottomUp(unbalancedRoot));
    }
}    