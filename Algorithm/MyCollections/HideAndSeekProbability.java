package MyCollections;

import java.math.BigInteger;

//小红和小紫在一个一维度的坐标系上玩捉迷藏，其范围为[1,?]。
//初始时小红位于工，小紫位于y。
//对于每次移动，若小红位于p(l<p<r),可以选择向左或者向右移动不超过a个距离，即移动后小红位于?
//[mar(l,p - a),min(r,p + a)]之一，且到每个位置的概率相等。
//<每次移动，若小紫位于q(l <q<r)，可以选择向左或者向右移动不超过6个距离，即移动后小紫位于
//[mmax(l,q-b),min(r,q +6)]之一，且到每个位置的概率相等。
//求两人恰好经过t秒，小红和小紫位于同一个位置的概率,答案对10°+ 7取模。
public class HideAndSeekProbability {
    private static final int MOD = 1000000007;

    public static int calculateProbability(int l, int r, int x, int y, int a, int b, int t) {
        int maxRange = r - l + 1;
        double[][][] dp = new double[t + 1][maxRange + 1][maxRange + 1];
        // 初始化第 0 秒时小红和小紫的位置概率
        dp[0][x - l + 1][y - l + 1] = 1;

        for (int time = 0; time < t; time++) {
            for (int redPos = 1; redPos <= maxRange; redPos++) {
                for (int purplePos = 1; purplePos <= maxRange; redPos++) {
                    if (dp[time][redPos][purplePos] == 0) continue;
                    // 小红可能的移动位置
                    int redLeft = Math.max(1, redPos - a);
                    int redRight = Math.min(maxRange, redPos + a);
                    int redMoveCount = redRight - redLeft + 1;
                    // 小紫可能的移动位置
                    int purpleLeft = Math.max(1, purplePos - b);
                    int purpleRight = Math.min(maxRange, purplePos + b);
                    int purpleMoveCount = purpleRight - purpleLeft + 1;

                    for (int newRedPos = redLeft; newRedPos <= redRight; newRedPos++) {
                        for (int newPurplePos = purpleLeft; newPurplePos <= purpleRight; newPurplePos++) {
                            dp[time + 1][newRedPos][newPurplePos] += dp[time][redPos][purplePos] / (redMoveCount * purpleMoveCount);
                        }
                    }
                }
            }
        }

        double result = 0;
        for (int pos = 1; pos <= maxRange; pos++) {
            result += dp[t][pos][pos];
        }

        return (int) (result * Math.pow(10, 9 + 7)) % MOD;
    }

    public static void main(String[] args) {
        int l = 1;
        int r = 10;
        int x = 3;
        int y = 7;
        int a = 2;
        int b = 2;
        int t = 3;
        int probability = calculateProbability(l, r, x, y, a, b, t);
        System.out.println("两人恰好经过 " + t + " 秒位于同一位置的概率（取模后）: " + probability);
    }
}    