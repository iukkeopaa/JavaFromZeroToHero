package MyCollections.FindSubtreeNodes;


//二叉树转换成中序链表，不能用额外空间，可以递归。不到五分钟递归
//解决。

public class BinaryTreeToInorderLinkedList {
    private TreeNode prev = null;
    private TreeNode head = null;

    public TreeNode convertToInorderList(TreeNode root) {
        inorderTraversal(root);
        return head;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeToInorderLinkedList converter = new BinaryTreeToInorderLinkedList();
        TreeNode head = converter.convertToInorderList(root);

        // 打印中序链表
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}    