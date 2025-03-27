package DaChangBrushUpClass.class1;

//给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与，再给定一个数target
//请问最后算出target的方法数
public class TargetSum {
    public static int findTargetSumWays(int[] arr, int target) {
        return dfs(arr, 0, 0, target);
    }

    private static int dfs(int[] arr, int index, int currentSum, int target) {
        if (index == arr.length) {
            return currentSum == target ? 1 : 0;
        }
        int positive = dfs(arr, index + 1, currentSum + arr[index], target);
        int negative = dfs(arr, index + 1, currentSum - arr[index], target);
        return positive + negative;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        int ways = findTargetSumWays(arr, target);
        System.out.println("得到目标值 " + target + " 的方法数为: " + ways);
    }

}
