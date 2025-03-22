package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;

import java.util.ArrayList;
import java.util.List;



public class FindMiddleElementInBST {
    public static int findMiddleElement(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int n = inorder.size();
        return inorder.get(n / 2);
    }

    private static void inorderTraversal(TreeNode node, List<Integer> inorder) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int middleElement = findMiddleElement(root);
        System.out.println("中间大的元素是: " + middleElement);
    }
}    