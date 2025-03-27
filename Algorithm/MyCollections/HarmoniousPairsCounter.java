package MyCollections;

//С����Ϊһ������(, y) ������� | -y| =||-|y|����ô��������Ǻ�г�ġ�
//���ڸ���һ������Ϊ n ������ a������y���ж��ٶ�(i,j)(i < j)����(ai,aj)�Ǻ�г�ġ�
public class HarmoniousPairsCounter {
    public static int countHarmoniousPairs(int[] a) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        // ͳ�������������� 0 ������
        for (int num : a) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // ����������������������
        int positivePairs = positiveCount * (positiveCount - 1) / 2;
        int negativePairs = negativeCount * (negativeCount - 1) / 2;
        int zeroPairs = zeroCount * (zeroCount - 1) / 2;
        int crossZeroPairs = zeroCount * (positiveCount + negativeCount);

        return positivePairs + negativePairs + zeroPairs + crossZeroPairs;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4};
        int result = countHarmoniousPairs(a);
        System.out.println("�����г��������������: " + result);
    }
}    