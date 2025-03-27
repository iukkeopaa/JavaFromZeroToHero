package MyCollections;

//题目内容
//小苯认为一个数是美丽数，当且仅当:如果将:不停除以2，直到:不整除2时停止，此时z恰好等于1.
//如果一个数美丽，则其美丽值为:以上操作中除以2的次数。
//否则一个数不美丽，则其美丽值为0。
//现在小苯有一个长度为n的数组a，他想知道a中所有连续子数组的和的美丽值之和是多少，请你帮他算一算吧。
//形式化的:记数字x的美丽值为f()则请你求出
//》”》”f(a +au+1+...+ar)
//(其中a + a1+1 + ...a,表示a数组在[l,,]这一段区间的所有元素之和)
public class BeautifulNumberSum {
    // 计算一个数的美丽值
    public static int beautyValue(int num) {
        int count = 0;
        while (num % 2 == 0) {
            num /= 2;
            count++;
        }
        return num == 1 ? count : 0;
    }

    // 计算数组中所有连续子数组和的美丽值之和
    public static int totalBeautyValue(int[] a) {
        int n = a.length;
        int[] prefixSum = new int[n + 1];
        // 计算前缀和
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }
        int total = 0;
        // 遍历所有可能的子数组
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int sum = prefixSum[r + 1] - prefixSum[l];
                total += beautyValue(sum);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int result = totalBeautyValue(a);
        System.out.println("所有连续子数组和的美丽值之和为: " + result);
    }
}    