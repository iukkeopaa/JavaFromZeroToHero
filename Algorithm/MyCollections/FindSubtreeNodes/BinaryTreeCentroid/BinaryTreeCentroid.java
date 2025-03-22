package MyCollections.FindSubtreeNodes.BinaryTreeCentroid;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    void addChild(TreeNode child) {
        this.children.add(child);
    }
}

public class BinaryTreeCentroid {
    private static int minSum = Integer.MAX_VALUE;
    private static int centroid = -1;

    public static int findCentroid(TreeNode root) {
        if (root == null) {
            return -1;
        }
        dfs(root, null);
        return centroid;
    }

    private static int dfs(TreeNode node, TreeNode parent) {
        int sum = 0;
        int subtreeSize = 1;

        for (TreeNode child : node.children) {
            if (child != parent) {
                int childSize = dfs(child, node);
                subtreeSize += childSize;
                sum += childSize + dfs(child, null);
            }
        }

        int otherSum = 0;
        if (parent != null) {
            otherSum = dfs(parent, node) + dfs(parent, null);
        }

        sum += otherSum;

        if (sum < minSum) {
            minSum = sum;
            centroid = node.val;
        }

        return subtreeSize;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        root.addChild(child1);
        root.addChild(child2);

        int centroid = findCentroid(root);
        System.out.println("二叉树的重心是: " + centroid);
    }
}    