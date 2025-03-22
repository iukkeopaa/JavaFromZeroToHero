package CrackingTheCodingInterview.ch9;

import java.util.Arrays;
import java.util.Comparator;

class Box {
    int width;
    int height;
    int depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // 判断当前箱子能否放在另一个箱子上面
    public boolean canBeAbove(Box other) {
        return this.width < other.width && this.height < other.height && this.depth < other.depth;
    }
}

public class StackBoxes {
    public static int stackHeight(Box[] boxes) {
        // 按高度降序排序
        Arrays.sort(boxes, Comparator.comparingInt(b -> -b.height));
        int[] memo = new int[boxes.length];
        int maxHeight = 0;
        for (int i = 0; i < boxes.length; i++) {
            int height = createStack(boxes, i, memo);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private static int createStack(Box[] boxes, int bottomIndex, int[] memo) {
        if (memo[bottomIndex] > 0) {
            return memo[bottomIndex];
        }
        Box bottom = boxes[bottomIndex];
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.length; i++) {
            if (boxes[i].canBeAbove(bottom)) {
                int height = createStack(boxes, i, memo);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        memo[bottomIndex] = maxHeight;
        return maxHeight;
    }

    public static void main(String[] args) {
        Box[] boxes = {
                new Box(1, 1, 1),
                new Box(2, 2, 2),
                new Box(3, 3, 3)
        };
        System.out.println("最高的箱子堆高度为: " + stackHeight(boxes));
    }
}    