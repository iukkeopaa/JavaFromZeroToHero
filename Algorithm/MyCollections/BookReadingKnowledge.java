package MyCollections;

//����ϲ�����飬���ڶ����һ���飬����nҳ��ÿ����һҳ����඼���Ի��ai��֪ʶ������������£����ÿ����
//���Զ���һҳ�����Ƕ�໹��һ��������������һ�����ڶ���������ҳ�����ݣ�ֻ�����ܻ�ȡ��֪ʶ��ֻ������������
//��Сʶ��֮�͵Ķ���֮һ�����ڶ��ֻ��m���ӵ�ʱ�����������Ȿ�飬������߶���������Ի�ö��ٵ�֪ʶ��
public class BookReadingKnowledge {

    public static int maxKnowledge(int[] a, int m) {
        int n = a.length;
        // dp[i][j] ��ʾ������ i ҳ������ j ����ʱ��õ����֪ʶ��
        int[][] dp = new int[n + 2][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // ������һҳ
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + a[i]);
                // ��������ҳ
                if (i + 1 < n) {
                    dp[i + 2][j + 1] = Math.max(dp[i + 2][j + 1], dp[i][j] + (a[i] + a[i + 1]) / 2);
                }
            }
        }

        int ans = 0;
        // �������һҳ��ͬʱ�仨�ѵ�������ҳ����ֵ
        for (int j = 0; j <= m; j++) {
            ans = Math.max(ans, dp[n][j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int m = 3;
        System.out.println("��������Ի�õ�֪ʶ����: " + maxKnowledge(a, m));
    }
}    