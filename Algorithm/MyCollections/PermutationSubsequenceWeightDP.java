package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С������һ�����е�ȨֵΪ:
//������в������ϸ���������ȨֵΪ0��
//�����ϸ�������������ȨֵΪ:���еĳ��ȡ�
//����С���и���Ϊn��a���飬����֪��a������"���С�������(��:����������һ������)��Ȩֵ֮�ͣ����������-
//��ɡ�
//��������
//ÿ�������ļ��ڶ���������������ݡ�
//��һ��һ�������� T(1 < T < 100)����ʾ�������ݵ�����
//����������ÿ��������ݣ�����������С�
//��һ��һ��������n(1 ��n �� 2x 10��)����ʾ����a�ĳ��ȡ�
//�ڶ���n������a?(1 �� ai�� n)����ʾ����a��
//(��֤���в���������n���ܺͲ�����3x 10%��)
public class PermutationSubsequenceWeightDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // �������ݵ�����

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // ���� a �ĳ���
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(calculateWeightSum(a));
        }
        scanner.close();
    }

    private static int calculateWeightSum(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        int maxVal = 0;
        for (int num : a) {
            maxVal = Math.max(maxVal, num);
        }

        int result = 0;
        for (int num : a) {
            if (num == 1) {
                dp[1] = 1;
            } else if (dp[num - 1] > 0) {
                dp[num] += dp[num - 1];
            }
            if (isValidPermutationEndingAt(dp, num)) {
                result += num;
            }
        }

        return result;
    }

    private static boolean isValidPermutationEndingAt(int[] dp, int x) {
        for (int i = 1; i <= x; i++) {
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
}    