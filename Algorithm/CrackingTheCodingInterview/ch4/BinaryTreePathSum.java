package CrackingTheCodingInterview.ch4;

import java.util.ArrayList;
import java.util.List;

// 定义二叉树节点类


public class BinaryTreePathSum {
    // 主方法，用于查找所有符合条件的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 存储当前路径
        List<Integer> path = new ArrayList<>();
        findPaths(root, sum, path, result);
        return result;
    }

    // 辅助方法，用于递归查找路径
    private void findPaths(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        // 将当前节点加入路径
        path.add(node.val);
        // 检查以当前节点为终点的路径是否满足条件
        int currentSum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            currentSum += path.get(i);
            if (currentSum == target) {
                result.add(new ArrayList<>(path.subList(i, path.size())));
            }
        }
        // 递归查找左子树和右子树
        findPaths(node.left, target, path, result);
        findPaths(node.right, target, path, result);
        // 回溯，移除当前节点
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // 构建一个示例二叉树
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
        int sum = 8;
        List<List<Integer>> paths = solution.pathSum(root, sum);
        // 打印所有符合条件的路径
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}    