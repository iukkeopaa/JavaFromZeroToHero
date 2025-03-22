package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTToDLL {
    private TreeNode prev = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        // 构建一个示例二叉查找树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        BSTToDLL converter = new BSTToDLL();
        TreeNode dllHead = converter.convert(root);

        // 打印双向链表
        TreeNode current = dllHead;
        while (current != null) {
            System.out.print(current.val);
            if (current.right != null) {
                System.out.print("=");
            }
            current = current.right;
        }
    }
}    