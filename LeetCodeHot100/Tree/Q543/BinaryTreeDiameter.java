package Tree.Q543;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeDiameter {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    int ans = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode u) {
        if (u == null) return 0;
        int l = dfs(u.left), r = dfs(u.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }



    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter solution = new BinaryTreeDiameter();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("二叉树的直径是: " + diameter);
    }
}    