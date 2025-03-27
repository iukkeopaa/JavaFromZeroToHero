package MyCollections;

//小红定义两个数组是互补的，当且仅当数组每一个位置的数字之和都相同。
//小红有两个长度为n的数组，分别是a和b，她想知道有多少个子序列对应的数组是互补的。
public class ComplementarySubsequences {
    public static int countComplementarySubsequences(int[] a, int[] b) {
        int n = a.length;
        int total = 0;
        // 遍历所有可能的子序列组合
        for (int mask = 0; mask < (1 << n); mask++) {
            int prevSum = -1;
            boolean isComplementary = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    int currentSum = a[i] + b[i];
                    if (prevSum == -1) {
                        prevSum = currentSum;
                    } else if (prevSum != currentSum) {
                        isComplementary = false;
                        break;
                    }
                }
            }
            if (isComplementary && Integer.bitCount(mask) > 0) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 3, 2};
        System.out.println(countComplementarySubsequences(a, b));
    }
}    