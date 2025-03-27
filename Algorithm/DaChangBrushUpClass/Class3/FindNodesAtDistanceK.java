package DaChangBrushUpClass.Class3;

import java.util.*;

//给定三个参数，二叉树的头节点head，树上某个节点target，正数K。从target开始，可以向上走或者向下走，返回与target的距离是K的所有节点
// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class FindNodesAtDistanceK {
    // 存储每个节点的父节点
    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // 先遍历树，记录每个节点的父节点
        dfs(root, null);

        // 用于存储距离 target 为 K 的节点
        List<Integer> result = new ArrayList<>();
        // 用于记录已经访问过的节点
        boolean[] visited = new boolean[501];
        // 从 target 节点开始进行深度优先搜索
        dfs(target, K, result, visited);

        return result;
    }

    // 记录每个节点的父节点
    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    // 从当前节点开始，找到距离为 K 的节点
    private void dfs(TreeNode node, int K, List<Integer> result, boolean[] visited) {
        if (node == null || visited[node.val]) {
            return;
        }
        visited[node.val] = true;
        if (K == 0) {
            result.add(node.val);
            return;
        }
        // 向下搜索左子树
        dfs(node.left, K - 1, result, visited);
        // 向下搜索右子树
        dfs(node.right, K - 1, result, visited);
        // 向上搜索父节点
        dfs(parent.get(node), K - 1, result, visited);
    }


    public static List<TreeNode> distanceKNodes(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        createParentMap(root, parents);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int curLevel = 0;
        List<TreeNode> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (curLevel == K) {
                    ans.add(cur);
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }
                if (parents.get(cur) != null && !visited.contains(parents.get(cur))) {
                    visited.add(parents.get(cur));
                    queue.offer(parents.get(cur));
                }
            }
            curLevel++;
            if (curLevel > K) {
                break;
            }
        }
        return ans;
    }

    public static void createParentMap(TreeNode cur, HashMap<TreeNode, TreeNode> parents) {
        if (cur == null) {
            return;
        }
        if (cur.left != null) {
            parents.put(cur.left, cur);
            createParentMap(cur.left, parents);
        }
        if (cur.right != null) {
            parents.put(cur.right, cur);
            createParentMap(cur.right, parents);
        }
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        FindNodesAtDistanceK solution = new FindNodesAtDistanceK();
        TreeNode target = root.left;
        int K = 2;
        List<Integer> result = solution.distanceK(root, target, K);
        System.out.println(result);
    }
}    