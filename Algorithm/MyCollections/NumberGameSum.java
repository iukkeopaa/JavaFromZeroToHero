package MyCollections;

import java.util.Arrays;

//��Ŀ����
//�����м�����������a1,��, an��Alice ����ȥ��������� d����
//Bob �������Ὣʣ����������m�������� -k
//Alice ��Ҫʣ����֮�;����ܴ�Bob ��Ҫʣ����֮�;�����С��
//���� Aice �� Bob ���㹻�������������ʣ����֮���Ƕ���,
public class NumberGameSum {

    public static int calculateSum(int[] numbers, int d, int m, int k) {
        int n = numbers.length;
        int maxSum = Integer.MIN_VALUE;

        // ö�� Alice �Ƴ� d ���������п������
        // ��λ������ö�������Ƴ����
        for (int aliceMask = 0; aliceMask < (1 << n); aliceMask++) {
            int removedCount = Integer.bitCount(aliceMask);
            if (removedCount > d) continue;

            int[] remaining = new int[n - removedCount];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if ((aliceMask & (1 << i)) == 0) {
                    remaining[index++] = numbers[i];
                }
            }

            // ��ʣ�������������
            Arrays.sort(remaining);

            // ö�� Bob ѡ�� m �������� -k �����п������
            int remainingLength = remaining.length;
            for (int bobMask = 0; bobMask < (1 << remainingLength); bobMask++) {
                int multipliedCount = Integer.bitCount(bobMask);
                if (multipliedCount > m) continue;

                int currentSum = 0;
                for (int i = 0; i < remainingLength; i++) {
                    if ((bobMask & (1 << i)) != 0) {
                        currentSum += remaining[i] * (-k);
                    } else {
                        currentSum += remaining[i];
                    }
                }

                // ��������
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int d = 1;
        int m = 2;
        int k = 2;
        int result = calculateSum(numbers, d, m, k);
        System.out.println("���ʣ����֮����: " + result);
    }
}    