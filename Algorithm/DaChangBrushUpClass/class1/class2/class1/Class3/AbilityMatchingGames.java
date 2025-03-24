package DaChangBrushUpClass.class1.class2.class1.Class3;

import java.util.Arrays;

//给定一个数组arr，代表每个人的能力值。再给定一个非负数k，如果两个人能力差值正好为k，那么可以凑在一起比赛
//一局比赛只有两个人，返回最多可以同时有多少场比赛

//例子：arr = [1, 2, 3, 4, 5], k=1
//1和2、3和4可以组成2场比赛，所以返回2

//具体的流程是，先排序数组arr
//然后使用双指针，一个指针i指向数组的开头，另一个指针j指向i+1的位置，然后判断arr[j] - arr[i]是否等于k
//如果等于k，说明可以凑成一场比赛，然后i和j都向后移动一位
//如果小于k，说明能力差值太小，j向后移动一位
//如果大于k，说明能力差值太大，i向后移动一位
//最后返回可以凑成的比赛场数
//时间复杂度是O(N*logN)，因为排序的时间复杂度是O(N*logN)，双指针的时间复杂度是O(N)，所以总的时间复杂度是O(N*logN)


public class AbilityMatchingGames {
    public static int maxMatches(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int used = -1;
        int i = 0;
        int j = 1;
        int matches = 0;
        while (j < arr.length) {
            if (arr[j] - arr[i] == k) {
                if (i != used) {
                    matches++;
                    used = j;
                }
                i++;
                j++;
            } else if (arr[j] - arr[i] > k) {
                i++;
                if (i == j) {
                    j++;
                }
            } else {
                j++;
            }
        }
        return matches;
    }

    // 暴力解
    public static int maxPairNum1(int[] arr, int k) {
        if (k < 0) {
            return -1;
        }
        return process1(arr, 0, k);
    }

    public static int process1(int[] arr, int index, int k) {
        int ans = 0;
        if (index == arr.length) {
            for (int i = 1; i < arr.length; i += 2) {
                if (arr[i] - arr[i - 1] == k) {
                    ans++;
                }
            }
        } else {
            for (int r = index; r < arr.length; r++) {
                swap(arr, index, r);
                ans = Math.max(ans, process1(arr, index + 1, k));
                swap(arr, index, r);
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 时间复杂度O(N*logN)
    public static int maxPairNum2(int[] arr, int k) {
        if (k < 0 || arr == null || arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int ans = 0;
        int N = arr.length;
        int L = 0;
        int R = 0;
        boolean[] usedR = new boolean[N];
        while (L < N && R < N) {
            if (usedR[L]) {
                L++;
            } else if (L >= R) {
                R++;
            } else { // 不止一个数，而且都没用过！
                int distance = arr[R] - arr[L];
                if (distance == k) {
                    ans++;
                    usedR[R++] = true;
                    L++;
                } else if (distance < k) {
                    R++;
                } else {
                    L++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 1;
        System.out.println("最多可以同时进行的比赛场数: " + maxMatches(arr, k));
    }
}    