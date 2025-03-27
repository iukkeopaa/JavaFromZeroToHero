package MyCollections;

import java.util.Scanner;

//��Ŀ����
//���ڸ�������ż��n��������m�������ʽ:
//cor��mod n
//����Ȼ�Ѳ����㣬���ԣ����ǽ���ʹ��һ������ķ�ʽ����n�Ķ�������ʽ:����һ���ɸ��������ɵ�����(
//41,��2,��, ��)�����У���i������a;����n�Ķ����Ʊ�ʾ�У��Ӹ�λ����λ��ǡ��������i��imod 2��������أ����
//����a={3,4,1,2}����ô����һ������a,�ʹ�����3 ��3 mod 2=1,�ڶ�������a,�ʹ�����4 ��4 mod2=0,��
//���գ����Եõ�n�Ķ����Ʊ�ʾΪ1110000100��
//��������
//��-��������������k,m(1 �Q����2x10';1��m�� 10��)��
//�ڶ������뤿��������a1,a2,��, a(1 �Q a?�� 10��)��
//����֮�⣬��֤���������ļ���q;֮�Ͳ�����10����
public class BinaryCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[k];
        int[] prefixSum = new int[k + 1];

        // ����ǰ׺��
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        long result = 0;
        long mod = (long) (2 * Math.PI);

        // ����ÿ�����紦
        for (int i = 0; i < k - 1; i++) {
            int position = prefixSum[i + 1];
            result = (result + fastPower(2, position, mod)) % mod;
        }

        result = (long) (Math.cos(result) % m);
        System.out.println(result);
        scanner.close();
    }

    // �������㷨
    public static long fastPower(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}    