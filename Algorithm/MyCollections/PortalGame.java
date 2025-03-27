package MyCollections;

import java.util.Scanner;

//��Ŀ����
//�������һ����������Ϸ��
//��Ϸ��ʼʱ�����һά�����:= 0�������м��������ţ�ÿ�������Ŷ���һ������ֵa;������
//ʹ�øô����Ŵ�: = tλ�ô��͵� =t+4��������������Ʒ��ֻ��ʹ��һ�Ρ�ͬʱ������һ ��"��ת�����ܣ�ʹ�ø�
//���ܿ���������λ�� = t"��ת����z = -t.
//������������˳��ʹ����Щ�����ţ��������κ�ʱ��ʹ�á���ת������(�����һ�Σ�Ҳ���Բ� ��)�����������д���|
//�󣬶�ൽ��ʼλ��: -0��Զ�ľ���Ϊ����?
//��������
//��һ��Ϊһ��������n(1 ��n�� 10'),
//�ڶ���Ϊn������ a1,a2,....,an(-104 �� ai �� 104)��
public class PortalGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] portals = new int[n];
        for (int i = 0; i < n; i++) {
            portals[i] = scanner.nextInt();
        }
        int maxDistance = calculateMaxDistance(portals);
        System.out.println(maxDistance);
        scanner.close();
    }

    public static int calculateMaxDistance(int[] portals) {
        int sum = 0;
        for (int portal : portals) {
            sum += portal;
        }

        int maxDist = Math.abs(sum);
        for (int portal : portals) {
            // ����ʹ�÷�ת���������ڵ�ǰ������
            int newSum = sum - 2 * portal;
            maxDist = Math.max(maxDist, Math.abs(newSum));
        }
        return maxDist;
    }
}    