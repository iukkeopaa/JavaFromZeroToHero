package Tree.Q98;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }


    public boolean isValidBST3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST3(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right &&
                isValidBST(node.left, left, x) &&
                isValidBST(node.right, x, right);
    }

    public boolean isValidBST5(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }

    private long[] dfs(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs(node.left);
        long[] right = dfs(node.right);
        long x = node.val;
        // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
        if (x <= left[1] || x >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树用于测试
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidBST solution = new ValidBST();
        boolean result = solution.isValidBST(root);
        System.out.println("该二叉树是否为有效二叉搜索树: " + result);
    }
}    