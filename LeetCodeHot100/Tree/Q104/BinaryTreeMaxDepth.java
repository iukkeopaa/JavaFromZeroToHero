package Tree.Q104;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    //层次遍历使用队列计数
    public int maxDepth2(TreeNode root) {
        // 空树，高度为 0
        if(root == null){
            return 0;
        }
        // 初始化队列和层次
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        // 当队列不为空
        while(!queue.isEmpty()){
            // 当前层的节点数
            int n = queue.size();
            // 弹出当前层的所有节点，并将所有子节点入队列
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        // 二叉树最大层次即为二叉树最深深度
        return depth;
    }


//    private static int maxDepth6(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        //DFS实现前序遍历，每个节点记录其所在深度
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//            TreeNode node = pair.first;
//            //DFS过程不断比较更新最大深度
//            maxDepth = Math.max(maxDepth, pair.second);
//            //记录当前节点所在深度
//            int curDepth = pair.second;
//            //当前节点的子节点入栈，同时深度+1
//            if (node.right != null) {
//                stack.push(new Pair<>(node.right, curDepth + 1));
//            }
//            if (node.left != null) {
//                stack.push(new Pair<>(node.left, curDepth + 1));
//            }
//        }
//        return maxDepth;
//    }



    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaxDepth solution = new BinaryTreeMaxDepth();
        int depth = solution.maxDepth(root);
        System.out.println("二叉树的最大深度是: " + depth);
    }
}    