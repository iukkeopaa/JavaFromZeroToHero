package Tree.Q114;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    private TreeNode head;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head; // 头插法，相当于链表的 root.next = head
        head = root; // 现在链表头节点是 root
    }

    public void flatten3(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }




    public static void main(String[] args) {
        // 构建一个简单的二叉树用于测试
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        BinaryTreeToLinkedList solution = new BinaryTreeToLinkedList();
        solution.flatten(root);

        // 打印展开后的链表
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}    