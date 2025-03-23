package DaChangBrushUpClass.class1.class2.class1.Class1;

// 一个数组中只有两种字符'G'和'B'，
// 可以让所有的G都放在左侧，所有的B都放在右侧
// 或者可以让所有的G都放在右侧，所有的B都放在左侧
// 但是只能在相邻字符之间进行交换操作，请问请问至少需要交换几次，
public class MinSwapStep {

    public static int minSwaps(char[] arr) {
        int n = arr.length;
        int gLeft = 0;
        int bLeft = 0;
        int gCount = 0;
        int bCount = 0;

        // 计算 G 都在左边的交换次数
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'G') {
                gLeft += i - gCount;
                gCount++;
            }
        }

        // 计算 B 都在左边的交换次数
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'B') {
                bLeft += i - bCount;
                bCount++;
            }
        }

        return Math.min(gLeft, bLeft);
    }

    public static int minSteps1(String s) {
        //判断两种移动的代价
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int gi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') {
                step1 += i - (gi++);
            }
        }
        int step2 = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'B') {
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);
    }

    // 可以让G在左，或者在右
    public static int minSteps2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int step2 = 0;
        int gi = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') { // 当前的G，去左边   方案1
                step1 += i - (gi++);
            } else {// 当前的B，去左边   方案2
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);
    }

    public static void main(String[] args) {
        char[] arr = {'G', 'B', 'G', 'B', 'B', 'G'};
        System.out.println("最少交换次数: " + minSwaps(arr));
    }
}
