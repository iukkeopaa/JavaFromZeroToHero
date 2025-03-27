package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С����һά�ȵ������У�������������������ƶ������õ�һ������Ϊn���ַ���s��������'<'��">'�����ַ���'<' ��
//ʾ�����ƶ���'>'��ʾ�����ƶ���
//С����֪����������ַ���s�ĵ�i(0 <i< n)���ַ���ʼ,Ȼ����S,S:+1,S+2,��.��˳�������ƶ�����ôС����:
//�оŻ�ص�ԭ�ء�
//ֵ��ע����ǣ�����Ҫ���������i(0<i< n)���ж��Ƿ����һ���ƶ���ʽ��ʹ��С����Իص�ԭ���Ҳ�һ����Ҫ
//ִ�е�sn-1��ÿ�����жϻ���Ӱ�졣
//��������
//��һ��һ������n(1 ��n��2 x 10'),��ʾ�ַ���s�ĳ��ȡ�
//�ڶ���һ���ַ���s��������'<'��'>'�����ַ���
//�������
//���������������i��������ʾ�ӵ�i���ַ���ʼ�ƶ���С����û�л���ص�ԭ�أ����л������1���������0��
public class RedMovementJudgment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print(canReturnToOrigin(s, i)? 1 : 0);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        scanner.close();
    }

    public static boolean canReturnToOrigin(String s, int start) {
        int balance = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                balance--;
            } else {
                balance++;
            }
            if (balance == 0) {
                return true;
            }
        }
        return false;
    }
}    