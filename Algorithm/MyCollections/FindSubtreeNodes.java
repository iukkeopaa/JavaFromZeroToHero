package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubtreeNodes {
    public static List<Integer> findSubtreeNodes(int[] nodes, int[] parents, int target) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        // 构建树结构
        for (int i = 0; i < nodes.length; i++) {
            int node = nodes[i];
            int parent = parents[i];
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
        }
        List<Integer> result = new ArrayList<>();
        dfs(tree, target, result);
        return result;
    }

    private static void dfs(Map<Integer, List<Integer>> tree, int node, List<Integer> result) {
        if (!tree.containsKey(node)) {
            return;
        }
        List<Integer> children = tree.get(node);
        for (int child : children) {
            result.add(child);
            dfs(tree, child, result);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        int[] parents = {0, 1, 1, 2, 2};
        int target = 1;
        List<Integer> subtreeNodes = findSubtreeNodes(nodes, parents, target);
        System.out.println("子树节点: " + subtreeNodes);
    }
}    