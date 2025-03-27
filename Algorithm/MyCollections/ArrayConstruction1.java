package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С��ϣ���㹹��һ������Ϊn������,����:
//1.�����е�ÿ��Ԫ��a����0 < a;< 2'
//2.��������Ԫ�ص�����С�ڵ�������Ԫ�ص���͡���
//a $ a2 ...ansa,&a?&...&an
//С����֪���ж����ֿ��ܵķ�������
//��������
//��һ��������������n��k��
//1 ��n�� 10'
//0��k�� 10'
//�������
//���һ����������ʾ��������������ķ����������ڴ𰸿��ܴܺ����10��+ 7ȡģ��
public class ArrayConstruction1 {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int limit = 1 << k;

        // dp[i][j][l] ��ʾ�Ѿ������� i ��Ԫ�أ�����Ϊ j�����Ϊ l �ķ�����
        long[][][] dp = new long[n + 1][limit][limit];
        dp[0][0][limit - 1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < limit; j++) {
                for (int l = 0; l < limit; l++) {
                    if (dp[i][j][l] == 0) continue;
                    for (int num = 1; num < limit; num++) {
                        int newXor = j ^ num;
                        int newAnd = l & num;
                        dp[i + 1][newXor][newAnd] = (dp[i + 1][newXor][newAnd] + dp[i][j][l]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < limit; j++) {
            for (int l = 0; l < limit; l++) {
                if (j <= l) {
                    ans = (ans + dp[n][j][l]) % MOD;
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}    