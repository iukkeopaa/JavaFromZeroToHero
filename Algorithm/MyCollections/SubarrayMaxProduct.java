package MyCollections;
//��Ŀ����
//С����һ������Ϊn������a��������:
//f(a)= a1 + a2 + ��. + an��(���������ֵ�����).
//g(a)= gcd(a1,a2,��,a?)��(���������ֵ����Լ��)��
//����С��ϣ�����a��ѡ��һ���ǿ�������b(����������������)�������������f(b)��g(b)�����ܴ����������һ��
//������ֵ�ɡ�
public class SubarrayMaxProduct {
    // ���������������Լ��
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int maxProduct(int[] a) {
        int n = a.length;
        int maxProduct = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;

        // �ҳ������е����Ԫ��
        for (int num : a) {
            maxElement = Math.max(maxElement, num);
        }

        // ���Ԫ�ص�ƽ����һ��Ǳ�ڵ����ֵ
        maxProduct = Math.max(maxProduct, maxElement * maxElement);

        // ö�����п��ܵ�������
        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            int currentGcd = a[i];
            for (int j = i; j < n; j++) {
                xorSum ^= a[j];
                // ���µ�ǰ����������Լ��
                if (j == i) {
                    currentGcd = a[i];
                } else {
                    currentGcd = gcd(currentGcd, a[j]);
                }
                int product = xorSum * currentGcd;
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println("���� f(b)��g(b) ֵΪ: " + maxProduct(a));
    }
}