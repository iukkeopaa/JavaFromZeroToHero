package MyCollections;

import java.util.Scanner;

//СA��СB���ǰ�ש�ˣ���Ϊ���Ե��������ʲ�ͬ����������Ϊ�Լ��ƶ��˲�ͬ��СĿ�ꡣСA����һ�ΰ�a1��ש������ÿ��һ�ξ�Ҫ��Ϣb1���ӣ�����Ŀ����һ���c1��ש;ͬ���ģ�СB����һ�ΰ�a2��ש������ÿ��һ�ξ�Ҫ��Ϣb2���ӣ�����Ŀ����һ���c2��ש��
//ÿ���������ͬ��ֻҪ����Լ���Ŀ��ͺã���֪ĳ��СA��СBͬʱ��ʼ��ש����������˭������Լ���Ŀ�ꣿ�����СA�������A���������СB�������B�������������ͬʱ��ɣ��������A&B����

//��������
//2
//7 9 19 9 1 89
//7 9 95 4 5 9
public class BrickMovingComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ����С A �������Ϣ
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        // ����С B �������Ϣ
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        // ����С A ���Ŀ������ʱ��
        int timesA = (int) Math.ceil((double) c1 / a1);
        int timeA = (timesA - 1) * b1;

        // ����С B ���Ŀ������ʱ��
        int timesB = (int) Math.ceil((double) c2 / a2);
        int timeB = (timesB - 1) * b2;

        // �ж�˭�����Ŀ��
        if (timeA < timeB) {
            System.out.println("A");
        } else if (timeA > timeB) {
            System.out.println("B");
        } else {
            System.out.println("A&B");
        }
    }
}    