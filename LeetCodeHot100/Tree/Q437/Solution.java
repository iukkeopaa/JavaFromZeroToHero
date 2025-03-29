package Tree.Q437;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 记录路径中某个前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 防止包含根节点的时候找不到
        map.put(0, 1);
        // 开始搜索
        dfs(root, map, 0, targetSum);
        // 返回值
        return ans;
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map, int currSum, int targetSum) {
        // 递归退出条件
        if (node == null) {
            return;
        }

        // 判断是否存在符合条件的前缀和
        currSum += node.val;
        ans += map.getOrDefault(currSum - targetSum, 0);

        // 将当前前缀和记录下来
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // 继续往下递归
        dfs(node.left, map, currSum, targetSum);
        dfs(node.right, map, currSum, targetSum);

        // 回溯，恢复状态
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
    }
}

