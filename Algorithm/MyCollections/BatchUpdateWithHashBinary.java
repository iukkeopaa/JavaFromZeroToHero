package MyCollections;

import java.util.HashMap;
import java.util.Map;

//题目内容
//小红给定一个数字:，现在她准备把其数位上的数字重新排列，例如: = 213，重排后可以是
//[123，132，231，312，321]，但不能是213，因为其没有进行重排，又例如10，仅存在|1]，重排后的 数字忽略掉
//前导零。
//℉请你帮助小红计算有多少个重排后的数字y，使得其数位之和是一个质数。
//输入描述
//第一行一个整数T(1 ≤<T ≤ 10%)，表示数据组数，对于每组数据格式为:
//-个整数?(1 ≤ ? ≤ 10”)，表示给定的数字。
//输出描述
//对于每组数据，每行输出一个整数，表示满足条件的数字个数。
public class BatchUpdateWithHashBinary {

    public static void batchUpdate(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int index = -1;

        // 二分查找第一个小于等于 target 的位置
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (index == -1) {
            return;
        }

        // 用哈希表统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int sum = 0;
        for (int i = index; i < n; i++) {
            int num = arr[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            sum += num;
        }

        // 批量更新
        int newSum = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (num > target) {
                newSum += target * freq;
            } else {
                newSum += num * freq;
            }
        }

        // 更新数组
        for (int i = index; i < n; i++) {
            arr[i] = Math.min(arr[i], target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 6, 4, 2};
        int target = 5;
        batchUpdate(arr, target);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}    