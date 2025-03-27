package DoubleArrows.Q11;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0; // 左指针，指向数组起始位置
        int right = height.length - 1; // 右指针，指向数组末尾位置
        int maxWater = 0; // 初始化最大水量为 0

        while (left < right) {
            // 计算当前两个指针所构成容器的水量
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            // 更新最大水量
            maxWater = Math.max(maxWater, currentWater);

            // 移动较短的那根垂线对应的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        System.out.println("容器可以储存的最大水量是: " + result);
    }
}