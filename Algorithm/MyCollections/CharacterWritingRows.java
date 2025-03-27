package MyCollections;

import java.util.Arrays;

//小红正在练字，一共有n个字，第i个字的笔画数为4:，文字之前没有顺序要求。
//现在小红准备将n个字分成若干行来写，小红认为同一行中如果存在两个笔画数一样的字会感觉到厌
//同时每行的数字个数不能超过k个，请问现在至少需要分成多少行。
public class CharacterWritingRows {
    public static int minRows(int[] strokes, int k) {
        int n = strokes.length;
        if (n == 0) {
            return 0;
        }
        // 对笔画数数组进行排序
        Arrays.sort(strokes);

        int rows = 0;
        int i = 0;
        while (i < n) {
            int currentRowCount = 1;
            int j = i + 1;
            // 尝试在当前行添加更多的字
            while (j < n && currentRowCount < k && strokes[j] != strokes[j - 1]) {
                currentRowCount++;
                j++;
            }
            // 完成一行的分配，行数加 1
            rows++;
            i = j;
        }
        return rows;
    }

    public static void main(String[] args) {
        int[] strokes = {1, 2, 3, 2, 4};
        int k = 3;
        int result = minRows(strokes, k);
        System.out.println("至少需要的行数: " + result);
    }
}    