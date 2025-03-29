package Tree.Q98;

import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(list);
        return list.get(k - 1);
    }
    void dfs(TreeNode root) {
        if (root == null) return ;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


}

