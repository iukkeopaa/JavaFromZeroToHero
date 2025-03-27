package MyCollections;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//小红拿到了一个二叉树，二叉树共有n个节点。小红希望你将所有节点赋值为1到n的正整数，且没有两个节点的值相等。需要满足：奇数层的权值和与偶数层的权值和之差的绝对值不超过1。
//如果有多种赋值方案，请返回任意一种方案。如果无解，请返回空树。
//给定的二叉树节点初始权值默认为-1。
public class BinaryTreeValueAssignment {
    private int[] values;
    private int index;

    public TreeNode assignValues(TreeNode root, int n) {
        if (n < 1 || n > 10) {
            return root;
        }
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }
        index = 0;
        dfs(root, 1, n);
        return root;
    }

    private void dfs(TreeNode node, int level, int n) {
        if (node == null) {
            return;
        }
        node.val = values[index++];
        dfs(node.left, level + 1, n);
        dfs(node.right, level + 1, n);
    }

    public static void main(String[] args) {
        BinaryTreeValueAssignment solution = new BinaryTreeValueAssignment();
        TreeNode root = new TreeNode(-1);
        // 这里简单构建一个只有根节点的二叉树，实际应用中需要根据具体情况构建完整二叉树
        TreeNode result = solution.assignValues(root, 5);
        // 可以添加打印结果的代码，查看赋值后的二叉树
    }
}