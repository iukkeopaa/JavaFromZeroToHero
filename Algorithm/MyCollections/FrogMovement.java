package MyCollections;

import java.util.Arrays;

//С����һ��һά������ϵ������һ����n���㣬����Ϊ1,2,��,��������һֻң�����ܣ���ʼʱλ��k�����ڣ�����ֽ��
//��д��һ��ָ�:
//ָ�:ָ�����������ƶ�һ����λ�������ǰλ��1����ԭ�ز�����
//��ָ��R:ָ�����������ƶ�һ����λ�������ǰλ��n����ԭ�ز�����
//��ָ��?:δ֪�������ɻ���R����ָ�������ƶ���
//����ָ��?��ȫ������ȡֵ��С����֪�����������и���ͣ����Щλ�á�����õ���ܳ�Ϊ�յ㣬���1���������0
public class FrogMovement {
    public static int[] possibleEndPositions(int n, int k, String instructions) {
        int minPos = k;
        int maxPos = k;
        int questionMarkCount = 0;

        // ����ָ�����ȷ��ָ����λ���Լ� ? ������
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                minPos = Math.max(1, minPos - 1);
                maxPos = Math.max(1, maxPos - 1);
            } else if (c == 'R') {
                minPos = Math.min(n, minPos + 1);
                maxPos = Math.min(n, maxPos + 1);
            } else {
                questionMarkCount++;
            }
        }

        // ���� ? ��������չλ�÷�Χ
        minPos = Math.max(1, minPos - questionMarkCount);
        maxPos = Math.min(n, maxPos + questionMarkCount);

        int[] result = new int[n + 1];
        for (int i = minPos; i <= maxPos; i++) {
            result[i] = 1;
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        String instructions = "R?L";
        int[] positions = possibleEndPositions(n, k, instructions);
        for (int pos : positions) {
            System.out.print(pos + " ");
        }
    }
}    