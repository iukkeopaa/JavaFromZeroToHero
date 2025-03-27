package MyCollections;

import java.util.Arrays;

//С����һ�����飬����Ҫ���������
//n
//?
//1
//n?1 �Σ�ÿ�β���������ѡ��
//1. ѡ��������������������
//x
//x ��
//y
//y�������Ǵ�������ɾ����Ȼ��
//x
//+
//y
//x+y �ĸ�λ���Ż���������
//2. ѡ��������������������
//x
//x ��
//y
//y�������Ǵ�������ɾ����Ȼ��
//x
//��
//y
//x��y �ĸ�λ���Ż���������
public class ArrayOperationSchemeCount {
    private static final int MOD = (int) (1e9 + 7);

    public static int[] calculateResult(int[] arr) {
        int n = arr.length;
        // dp[i][j][k] ��ʾ������ arr[i...j] ��������Ϊ k �ķ�����
        int[][][] dp = new int[n][n][10];

        // ��ʼ������Ԫ�ص����
        for (int i = 0; i < n; i++) {
            dp[i][i][arr[i]] = 1;
        }

        // ö�����䳤��
        for (int len = 2; len <= n; len++) {
            // ö���������
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // ö�ٷָ��
                for (int k = i; k < j; k++) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 10; y++) {
                            if (dp[i][k][x] > 0 && dp[k + 1][j][y] > 0) {
                                int sum = (x + y) % 10;
                                int product = (x * y) % 10;
                                dp[i][j][sum] = (int) ((dp[i][j][sum] + (long) dp[i][k][x] * dp[k + 1][j][y]) % MOD);
                                dp[i][j][product] = (int) ((dp[i][j][product] + (long) dp[i][k][x] * dp[k + 1][j][y]) % MOD);
                            }
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = calculateResult(arr);
        System.out.println(Arrays.toString(result));
    }
}    