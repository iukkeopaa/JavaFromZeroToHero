package Tree.Q230;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class KthSmallestElementInBST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉搜索树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        int k = 2;
        int kthSmallest = solution.kthSmallest(root, k);
        System.out.println("第 " + k + " 小的元素是: " + kthSmallest);
    }
}    