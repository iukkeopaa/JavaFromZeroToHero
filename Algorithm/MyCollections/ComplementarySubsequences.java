package MyCollections;

//С�춨�����������ǻ����ģ����ҽ�������ÿһ��λ�õ�����֮�Ͷ���ͬ��
//С������������Ϊn�����飬�ֱ���a��b������֪���ж��ٸ������ж�Ӧ�������ǻ����ġ�
public class ComplementarySubsequences {
    public static int countComplementarySubsequences(int[] a, int[] b) {
        int n = a.length;
        int total = 0;
        // �������п��ܵ����������
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