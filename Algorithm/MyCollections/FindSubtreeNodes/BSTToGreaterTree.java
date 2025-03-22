package MyCollections.FindSubtreeNodes;



//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
//使得每个节点的值是原来的节点值加上所有大于它的节点值之和
public class BSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // 先遍历右子树
            convertBST(root.right);
            // 更新累加和
            sum += root.val;
            // 更新当前节点的值
            root.val = sum;
            // 再遍历左子树
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉搜索树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        BSTToGreaterTree solution = new BSTToGreaterTree();
        TreeNode greaterTree = solution.convertBST(root);

        // 可以添加遍历累加树的代码来验证结果
    }
}    