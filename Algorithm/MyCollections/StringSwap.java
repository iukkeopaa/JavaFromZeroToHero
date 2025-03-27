package MyCollections;

//小红了一个01串s。她将进行恰好一次以下操 作:
//选择下标i,j(i≠ j)，交换si和sj。
//小红想知道，不同的操作方案，最终能生成多少不同的字符串?
public class StringSwap {
    public static int countDistinctStrings(String s) {
        int n = s.length();
        int count0 = 0;
        int count1 = 0;

        // 统计字符串中 0 和 1 的数量
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        // 如果字符串中全是 0 或者全是 1，无法通过交换得到不同的字符串
        if (count0 == 0 || count1 == 0) {
            return 0;
        }

        // 计算不同的交换方案数量
        return count0 * count1;
    }

    public static void main(String[] args) {
        String s = "010";
        int result = countDistinctStrings(s);
        System.out.println("不同的字符串数量为: " + result);
    }
}    