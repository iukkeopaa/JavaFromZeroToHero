package MyCollections;

import java.util.Arrays;

//С���������֣�һ����n���֣���i���ֵıʻ���Ϊ4:������֮ǰû��˳��Ҫ��
//����С��׼����n���ֳַ���������д��С����Ϊͬһ����������������ʻ���һ�����ֻ�о�����
//ͬʱÿ�е����ָ������ܳ���k������������������Ҫ�ֳɶ����С�
public class CharacterWritingRows {
    public static int minRows(int[] strokes, int k) {
        int n = strokes.length;
        if (n == 0) {
            return 0;
        }
        // �Աʻ��������������
        Arrays.sort(strokes);

        int rows = 0;
        int i = 0;
        while (i < n) {
            int currentRowCount = 1;
            int j = i + 1;
            // �����ڵ�ǰ����Ӹ������
            while (j < n && currentRowCount < k && strokes[j] != strokes[j - 1]) {
                currentRowCount++;
                j++;
            }
            // ���һ�еķ��䣬������ 1
            rows++;
            i = j;
        }
        return rows;
    }

    public static void main(String[] args) {
        int[] strokes = {1, 2, 3, 2, 4};
        int k = 3;
        int result = minRows(strokes, k);
        System.out.println("������Ҫ������: " + result);
    }
}    