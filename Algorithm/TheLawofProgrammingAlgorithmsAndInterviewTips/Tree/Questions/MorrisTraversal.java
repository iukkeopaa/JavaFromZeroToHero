package TheLawofProgrammingAlgorithmsAndInterviewTips.Tree.Questions;


public class MorrisTraversal {
    // 前序遍历
    public static void preorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    System.out.print(current.val + " ");
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    // 中序遍历
    public static void inorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    // 后序遍历
    public static void postorderTraversal(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode current = dummy;
        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    reversePrint(current.left);
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    private static void reversePrint(TreeNode from) {
        TreeNode to = reverse(from);
        TreeNode p = to;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.right;
        }
        reverse(to);
    }

    private static TreeNode reverse(TreeNode node) {
        TreeNode prev = null;
        TreeNode current = node;
        while (current != null) {
            TreeNode next = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("前序遍历结果: ");
        preorderTraversal(root);

        System.out.print("中序遍历结果: ");
        inorderTraversal(root);

        System.out.print("后序遍历结果: ");
        postorderTraversal(root);
    }
}    