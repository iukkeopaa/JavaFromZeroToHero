package CrackingTheCodingInterview.ch4;

// 定义二叉树节点类


public class SubtreeCheck {
    // 判断 T2 是否为 T1 的子树
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        // 如果当前节点开始的子树和 T2 相同
        if (isSameTree(T1, T2)) {
            return true;
        }
        // 递归检查左子树和右子树
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    // 判断两棵树是否完全相同
    private static boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        // 递归检查左子树和右子树
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }

    public static void main(String[] args) {
        // 构建 T1 树
        TreeNode T1 = new TreeNode(1);
        T1.left = new TreeNode(2);
        T1.right = new TreeNode(3);
        T1.left.left = new TreeNode(4);
        T1.left.right = new TreeNode(5);

        // 构建 T2 树
        TreeNode T2 = new TreeNode(2);
        T2.left = new TreeNode(4);
        T2.right = new TreeNode(5);

        // 调用 isSubtree 方法进行判断
        boolean result = isSubtree(T1, T2);
        System.out.println("T2 是否为 T1 的子树: " + result);
    }
}    