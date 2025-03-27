package DoubleArrows.Q42;

import static LeetCodeHot100.DoubleArrows.Q42.TrappingRainWaterWithMonotonicStack.trap;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }



    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        // 存储每个位置左侧的最大高度
        int[] leftMax = new int[n];
        // 存储每个位置右侧的最大高度
        int[] rightMax = new int[n];

        // 计算每个位置左侧的最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 计算每个位置右侧的最大高度
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;
        // 计算每个位置能接住的雨水量并累加
        for (int i = 0; i < n; i++) {
            // 每个位置能接住的雨水量为左右最大高度的较小值减去当前高度
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += water;
        }
        return result;
    }


}



