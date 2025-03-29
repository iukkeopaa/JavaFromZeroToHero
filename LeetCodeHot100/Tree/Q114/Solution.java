package Tree.Q114;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution1 {
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        //将根节点的左子树变成链表
        flatten(root.left);
        //将根节点的右子树变成链表
        flatten(root.right);
        TreeNode temp = root.right;
        //把树的右边换成左边的链表
        root.right = root.left;
        //记得要将左边置空
        root.left = null;
        //找到树的最右边的节点
        while(root.right != null) root = root.right;
        //把右边的链表接到刚才树的最右边的节点
        root.right = temp;
    }

    public void flatten2(TreeNode root) {
        if(root==null) {
            return;
        }
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        //前序遍历整棵二叉树
        dfs(root,res);
        TreeNode head = res.removeFirst();
        head.left = null;
        //遍历链表，将链表中的TreeNode节点前后串联起来
        while(res.size()>0) {
            TreeNode tmp = res.removeFirst();
            tmp.left = null;
            head.right = tmp;
            head = head.right;
        }
    }

    //前序遍历整棵二叉树，并将遍历的结果放到数组中
    void dfs(TreeNode root, List<TreeNode> res) {
        if(root==null) {
            return;
        }
        res.add(root);
        dfs(root.left,res);
        dfs(root.right,res);
    }

    public void flatten4(TreeNode root) {
        if(root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode pre = new TreeNode(-1);
        while(stack.size()>0) {
            //用栈作为辅助数据结构，从栈中弹出元素后
            //先将右节点放到栈中，再将左节点放入栈中，模拟前序遍历
            TreeNode tmp = stack.pop();
            pre.left = null;
            pre.right = tmp;
            //先放入右节点，再放入左边点，顺序不能反了
            if(tmp.right!=null) {
                stack.add(tmp.right);
            }
            if(tmp.left!=null) {
                stack.add(tmp.left);
            }
            pre = pre.right;
        }
    }


    public void flatten344(TreeNode root) {
        helper(root);
    }

    void helper(TreeNode root) {
        if(root==null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        //将右子树挂到 左子树的最右边
        //再将整个左子树挂到根节点的右边
        if(root.left!=null) {
            TreeNode pre = root.left;
            while(pre.right!=null) {
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
//    public void flatten23424(TreeNode root) {
//        helper(root);
//    }
//
//    TreeNode pre = null;
//    void helper(TreeNode root) {
//        if(root==null) {
//            return;
//        }
//        //右节点-左节点-根节点 这种顺序正好跟前序遍历相反
//        //用pre节点作为媒介，将遍历到的节点前后串联起来
//        helper(root.right);
//        helper(root.left);
//        root.left = null;
//        root.right = pre;
//        pre = root;
//    }



}




