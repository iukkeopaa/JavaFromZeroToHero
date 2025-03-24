package DaChangBrushUpClass.class1.class2.class1.Class4;

//返回一个数组中所选数字不能相邻的情况下最大子序列累加和

//思路：动态规划
//1.定义一个变量incl，用于表示当前数字被选中时的最大子序列累加和
//2.定义一个变量excl，用于表示当前数字不被选中时的最大子序列累加和
//3.遍历数组，对于每个数字，计算incl和excl的新值
//4.计算incl的新值：excl + 当前数字

//给出一个具体的例子
//arr = [5, 5, 10, 100, 10, 5]
//1.初始化incl = 5，excl = 0
//2.遍历数组，对于数字5，计算incl和excl的新值
//3.计算incl的新值：excl + 5 = 0 + 5 = 5
//4.计算excl的新值：max(incl, excl) = max(5, 0) = 5
//5.遍历数组，对于数字5，计算incl和excl的新值
//6.计算incl的新值：excl + 5 = 5 + 5 = 10
//7.计算excl的新值：max(incl, excl) = max(10, 5) = 10
//8.遍历数组，对于数字10，计算incl和excl的新值
//9.计算incl的新值：excl + 10 = 10 + 10 = 20
//10.计算excl的新值：max(incl, excl) = max(20, 10) = 20
//11.遍历数组，对于数字100，计算incl和excl的新值
//12.计算incl的新值：excl + 100 = 20 + 100 = 120
//13.计算excl的新值：max(incl, excl) = max(120, 20) = 120
//14.遍历数组，对于数字10，计算incl和excl的新值
//15.计算incl的新值：excl + 10 = 120 + 10 = 130
//16.计算excl的新值：max(incl, excl) = max(130, 120) = 130
//17.遍历数组，对于数字5，计算incl和excl的新值
//18.计算incl的新值：excl + 5 = 130 + 5 = 135


public class MaxNonAdjacentSum {
    public static int maxNonAdjacentSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int incl = arr[0];
        int excl = 0;
        for (int i = 1; i < arr.length; i++) {
            int newExcl = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = newExcl;
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println("最大不相邻子序列和为: " + maxNonAdjacentSum(arr));
    }
}    