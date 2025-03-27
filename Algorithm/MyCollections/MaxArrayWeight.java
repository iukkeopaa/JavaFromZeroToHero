package MyCollections;

//��Ŀ����
//С����һ������Ϊn������a��һ����Ϊn���ַ���s���������Խ������и��1�顣
//���������ȨֵΪ����Ԫ�ص�Ȩֵ֮�͡����������еĵ�1��Ԫ�أ���Ȩֵ���㷽ʽΪ:0p(i)x(a + j)
//op(i)��ֵȡ�����ַ���s�ĵ�i���ַ�:
//��s:='1'����op(i)= 1
//��s:='0'����op(i)= -1
//��j��ʾa:���ڵĿ�ı��(��1��ʼ)
//С����Ҫͨ��������иʽ��ʹ���������Ȩֵ������������������ܵ����Ȩֵ��
public class MaxArrayWeight {
    public static int calculateMaxWeight(int[] a, String s) {
        int n = a.length;
        // ���и�ʱ��Ȩֵ
        int noCutWeight = 0;
        for (int i = 0; i < n; i++) {
            int op = s.charAt(i) == '1' ? 1 : -1;
            noCutWeight += op * (a[i] + 1);
        }

        int maxWeight = noCutWeight;
        // �����и���� i ��
        int leftWeight = 0;
        for (int i = 0; i < n - 1; i++) {
            int op = s.charAt(i) == '1' ? 1 : -1;
            leftWeight += op * (a[i] + 1);
            int rightWeight = 0;
            for (int j = i + 1; j < n; j++) {
                int op2 = s.charAt(j) == '1' ? 1 : -1;
                rightWeight += op2 * (a[j] + 2);
            }
            maxWeight = Math.max(maxWeight, leftWeight + rightWeight);
        }

        return maxWeight;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        String s = "101";
        int result = calculateMaxWeight(a, s);
        System.out.println("���ȨֵΪ: " + result);
    }
}    