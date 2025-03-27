package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С����n��ճ�ϼ�����i��ճ�ϼ���ճ�϶�Ϊ44�� ���������ѡk(1 <k< n)��ճ�ϼ����ʹ��,����ѡ��k��ճ�ϼ���
//��Ϊa,4��, ,����ô,���ճ�ϱ�Ϊ��ѡճ�ϼ���ʼճ�϶ȵ��������god(a,4,,),��k = 1ʱ,��ʱ��
//��ճ�϶�Ϊa6
//����С����ѯ�ʴ���ʹ��ճ�ϼ�����ͺ����ճ�϶�Ϊ����?
//���������ָ������������Լ��������һ�������磬12��30�Ĺ�Լ����1,2.3.6����������Լ����6�����
//god(12,30)=6.
//��������
//��һ��һ������n(1 �� n�� 10'),��ʾճ�ϼ�������
//�ڶ��м�����������i������Ϊa;(1 < a< 10��),��ʾ��i��ճ�ϼ���ճ�϶ȡ�
//�������
//�����������Կո�������ֱ��ʾ��һ����Ʒ�������ʹ��ճ�ϼ�����ͺ����ճ�϶ȡ�
public class AdhesiveBondingDegree {
    // �������������������
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] adhesives = new int[n];
        int maxDegree = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            adhesives[i] = scanner.nextInt();
            if (adhesives[i] > maxDegree) {
                maxDegree = adhesives[i];
            }
        }

        int minDegree = adhesives[0];
        for (int i = 1; i < n; i++) {
            minDegree = gcd(minDegree, adhesives[i]);
        }

        System.out.println(minDegree + " " + maxDegree);
    }
}    