package MyCollections.FindSubtreeNodes;

//求一棵树第 k 层的节点个数
// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeKthLevelNodeCount {
    // 计算第 k 层节点个数的方法
    public static int countNodesAtKthLevel(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return countNodesAtKthLevel(root.left, k - 1) + countNodesAtKthLevel(root.right, k - 1);
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int k = 3;
        int count = countNodesAtKthLevel(root, k);
        System.out.println("第 " + k + " 层的节点个数是: " + count);
    }
}    