package MyCollections;

import java.util.Arrays;

//小美有一个一维的坐标系，上面一共有n个点，依次为1,2,…,”，她有一只遥控青蛙，初始时位于k。现在，她在纸上
//书写了一个指令集:
//指令工:指挥青蛙向左移动一个单位，如果当前位于1，则原地不动。
//。指令R:指挥青蛙向右移动一个单位，如果当前位于n，则原地不动。
//。指令?:未知，随机变成或者R，并指挥青蛙移动。
//对于指令?的全部可能取值，小美想知道青蛙最终有概率停在哪些位置。如果该点可能成为终点，输出1，否则输出0
public class FrogMovement {
    public static int[] possibleEndPositions(int n, int k, String instructions) {
        int minPos = k;
        int maxPos = k;
        int questionMarkCount = 0;

        // 遍历指令，计算确定指令后的位置以及 ? 的数量
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                minPos = Math.max(1, minPos - 1);
                maxPos = Math.max(1, maxPos - 1);
            } else if (c == 'R') {
                minPos = Math.min(n, minPos + 1);
                maxPos = Math.min(n, maxPos + 1);
            } else {
                questionMarkCount++;
            }
        }

        // 根据 ? 的数量扩展位置范围
        minPos = Math.max(1, minPos - questionMarkCount);
        maxPos = Math.min(n, maxPos + questionMarkCount);

        int[] result = new int[n + 1];
        for (int i = minPos; i <= maxPos; i++) {
            result[i] = 1;
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        String instructions = "R?L";
        int[] positions = possibleEndPositions(n, k, instructions);
        for (int pos : positions) {
            System.out.print(pos + " ");
        }
    }
}    