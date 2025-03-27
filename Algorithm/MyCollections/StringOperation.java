package MyCollections;

import java.util.Scanner;

//��Ŀ����
//��С������һ������Ϊn ���ַ���s���������ζ�ÿһ��i= 1,2,��,n �������²���:
//���s�ĵ�i���ַ�Ϊ��д��ĸ�������滻Ϊ��ĸ������һ����ĸ(�ر�ģ�2 �滻Ϊ A);
//���s�ĵ�i���ַ�ΪСд��ĸ�������滻Ϊ��ĸ������һ����ĸ(�ر�ģ�a �滻Ϊ z)��
//���s�ĵ�i���ַ�Ϊ���֣������滻Ϊ���1(�ر�ģ�9 �滻Ϊ 0);
//���s�ĵ�i���ַ�Ϊ�������ݣ������һ���»���"����
//��������
//��һ������һ������ n(1 �� n��3 x 10')�����ַ����ĳ��ȡ�
//�ڶ�������һ������Ϊ�����������֡���Сд��ĸ���ո�!?.+-*/���߸�������Ƿ��Ź��ɵ��ַ���s�����
//�������ַ������ر�ģ���֤�ַ�������β��Ϊ�ո�
//�������
//��һ�������һ���ַ������������������ַ�����
public class StringOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                if (c == 'Z') {
                    result.append('A');
                } else {
                    result.append((char) (c + 1));
                }
            } else if (Character.isLowerCase(c)) {
                if (c == 'a') {
                    result.append('z');
                } else {
                    result.append((char) (c - 1));
                }
            } else if (Character.isDigit(c)) {
                if (c == '9') {
                    result.append('0');
                } else {
                    result.append((char) (c + 1));
                }
            } else {
                result.append("_");
            }
        }
        System.out.println(result.toString());
        scanner.close();
    }
}    