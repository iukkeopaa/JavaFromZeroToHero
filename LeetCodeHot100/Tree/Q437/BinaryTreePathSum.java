package Tree.Q437;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 包含当前节点的路径数
        int pathsFromRoot = countPaths(root, targetSum);
        // 左子树中的路径数
        int pathsInLeft = pathSum(root.left, targetSum);
        // 右子树中的路径数
        int pathsInRight = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsInLeft + pathsInRight;
    }

    private int countPaths(TreeNode node, int remainingSum) {
        if (node == null) {
            return 0;
        }
        int paths = 0;
        if (node.val == remainingSum) {
            paths++;
        }
        // 继续在左子树中寻找
        paths += countPaths(node.left, remainingSum - node.val);
        // 继续在右子树中寻找
        paths += countPaths(node.right, remainingSum - node.val);

        return paths;
    }


    Map<Long, Integer> map = new HashMap<>();
    int ans, t;
    public int pathSum2(TreeNode root, int _t) {
        if (root == null) return 0;
        t = _t;
        map.put(0L, 1);
        dfs(root, root.val);
        return ans;
    }
    void dfs(TreeNode root, long val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }


    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        BinaryTreePathSum solution = new BinaryTreePathSum();
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println("路径数目: " + result);
    }
}    