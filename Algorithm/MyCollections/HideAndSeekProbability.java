package MyCollections;

import java.math.BigInteger;

//С���С����һ��һά�ȵ�����ϵ����׽�Բأ��䷶ΧΪ[1,?]��
//��ʼʱС��λ�ڹ���С��λ��y��
//����ÿ���ƶ�����С��λ��p(l<p<r),����ѡ��������������ƶ�������a�����룬���ƶ���С��λ��?
//[mar(l,p - a),min(r,p + a)]֮һ���ҵ�ÿ��λ�õĸ�����ȡ�
//<ÿ���ƶ�����С��λ��q(l <q<r)������ѡ��������������ƶ�������6�����룬���ƶ���С��λ��
//[mmax(l,q-b),min(r,q +6)]֮һ���ҵ�ÿ��λ�õĸ�����ȡ�
//������ǡ�þ���t�룬С���С��λ��ͬһ��λ�õĸ���,�𰸶�10��+ 7ȡģ��
public class HideAndSeekProbability {
    private static final int MOD = 1000000007;

    public static int calculateProbability(int l, int r, int x, int y, int a, int b, int t) {
        int maxRange = r - l + 1;
        double[][][] dp = new double[t + 1][maxRange + 1][maxRange + 1];
        // ��ʼ���� 0 ��ʱС���С�ϵ�λ�ø���
        dp[0][x - l + 1][y - l + 1] = 1;

        for (int time = 0; time < t; time++) {
            for (int redPos = 1; redPos <= maxRange; redPos++) {
                for (int purplePos = 1; purplePos <= maxRange; redPos++) {
                    if (dp[time][redPos][purplePos] == 0) continue;
                    // С����ܵ��ƶ�λ��
                    int redLeft = Math.max(1, redPos - a);
                    int redRight = Math.min(maxRange, redPos + a);
                    int redMoveCount = redRight - redLeft + 1;
                    // С�Ͽ��ܵ��ƶ�λ��
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
        System.out.println("����ǡ�þ��� " + t + " ��λ��ͬһλ�õĸ��ʣ�ȡģ��: " + probability);
    }
}    