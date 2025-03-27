package MyCollections;

//С���õ���һ����СΪn�����飬��ϣ��ɾ��һ�������ʹ��ʣ������Ԫ�صĳ˻�δβ�����Ф���0��С����֪
//����һ���ж����ֲ�ͬ��ɾ������?
public class ArrayDeletionScheme {
    public static int countWays(int[] arr, int k) {
        int n = arr.length;
        // ǰ׺�����飬���ڴ洢 2 �� 5 ����������
        int[][] prefixSum = new int[n + 1][2];

        // ����ǰ׺��
        for (int i = 1; i <= n; i++) {
            int num = arr[i - 1];
            int twoCount = 0, fiveCount = 0;
            // ͳ������ 2 �ĸ���
            while (num % 2 == 0) {
                twoCount++;
                num /= 2;
            }
            // ͳ������ 5 �ĸ���
            while (num % 5 == 0) {
                fiveCount++;
                num /= 5;
            }
            // ����ǰ׺������
            prefixSum[i][0] = prefixSum[i - 1][0] + twoCount;
            prefixSum[i][1] = prefixSum[i - 1][1] + fiveCount;
        }

        int ways = 0;
        // ö�����п��ܵ�ɾ������
        for (int l = 0; l <= n; l++) {
            for (int r = l; r <= n; r++) {
                // ����ʣ��Ԫ�������� 2 ������
                int totalTwo = prefixSum[n][0] - (prefixSum[r][0] - prefixSum[l][0]);
                // ����ʣ��Ԫ�������� 5 ������
                int totalFive = prefixSum[n][1] - (prefixSum[r][1] - prefixSum[l][1]);
                // ���ʣ��Ԫ�س˻�ĩβ 0 �������Ƿ���������
                if (Math.min(totalTwo, totalFive) >= k) {
                    ways++;
                }
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 20};
        int k = 2;
        System.out.println(countWays(arr, k));
    }
}    