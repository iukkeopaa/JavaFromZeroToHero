package MyCollections;

//题目内容
//小红有一个长度为n的数组a和一个度为n的字符串s。她最多可以将数组切割成1块。
//定义数组的权值为所有元素的权值之和。对于数组中的第1个元素，其权值计算方式为:0p(i)x(a + j)
//op(i)的值取决手字符串s的第i个字符:
//若s:='1'，则op(i)= 1
//若s:='0'，则op(i)= -1
//”j表示a:所在的块的编号(从1开始)
//小红想要通过合理的切割方式，使得数组的总权值最大，请你帮她计算出可能的最大权值。
public class MaxArrayWeight {
    public static int calculateMaxWeight(int[] a, String s) {
        int n = a.length;
        // 不切割时的权值
        int noCutWeight = 0;
        for (int i = 0; i < n; i++) {
            int op = s.charAt(i) == '1' ? 1 : -1;
            noCutWeight += op * (a[i] + 1);
        }

        int maxWeight = noCutWeight;
        // 假设切割点在 i 处
        int leftWeight = 0;
        for (int i = 0; i < n - 1; i++) {
            int op = s.charAt(i) == '1' ? 1 : -1;
            leftWeight += op * (a[i] + 1);
            int rightWeight = 0;
            for (int j = i + 1; j < n; j++) {
                int op2 = s.charAt(j) == '1' ? 1 : -1;
                rightWeight += op2 * (a[j] + 2);
            }
            maxWeight = Math.max(maxWeight, leftWeight + rightWeight);
        }

        return maxWeight;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        String s = "101";
        int result = calculateMaxWeight(a, s);
        System.out.println("最大权值为: " + result);
    }
}    