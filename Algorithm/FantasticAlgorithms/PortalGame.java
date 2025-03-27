package FantasticAlgorithms;

//多多在玩一个传送门游戏。
//游戏开始时多多在一维数轴的:=0处。他有几个传送门，每个传送门都有一个传送值4:，他能
//使用该传送门从… = t位置传送到:; =t+@，传送门是消耗品，只能使用一次。同时他还有一 个”反转”技能，使用该
//技能可以立即从位置2 = t“反转“到z = -t.
//必须从1到n使用这些传送门，可以在任何时候使用“反转“技能(最多用一次，也可以不 用)，问用完所有传送门后，
//多多到初始位置: -0最远的距离为多少?
public class PortalGame {
    /**
     * 计算多多使用传送门后距离初始位置的最远距离
     * @param portals 传送门的传送值数组
     * @return 最远距离
     */
    public static int maxDistance(int[] portals) {
        // 传送门的数量
        int n = portals.length;
        // 前缀和数组，用于快速计算区间和
        int[] prefixSum = new int[n + 1];

        // 计算前缀和
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + portals[i];
        }

        // 初始化最大距离为不使用反转技能的距离
        int maxDist = Math.abs(prefixSum[n]);

        // 尝试在每个位置使用反转技能
        for (int i = 0; i <= n; i++) {
            // 计算使用反转技能后的距离
            int currentDist = Math.abs(prefixSum[n] - 2 * prefixSum[i]);
            // 更新最大距离
            maxDist = Math.max(maxDist, currentDist);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        // 示例传送门传送值数组
        int[] portals = {1, -2, 3};
        // 调用 maxDistance 方法计算最远距离
        int result = maxDistance(portals);
        // 输出结果
        System.out.println("多多到初始位置的最远距离是: " + result);
    }
}
    