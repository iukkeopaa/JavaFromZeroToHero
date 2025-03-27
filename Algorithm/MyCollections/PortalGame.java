package MyCollections;

import java.util.Scanner;

//题目内容
//多多在玩一个传送门游戏。
//游戏开始时多多在一维数轴的:= 0处。他有几个传送门，每个传送门都有一个传送值a;，他能
//使用该传送门从: = t位置传送到 =t+4，传送门是消耗品，只能使用一次。同时他还有一 个"反转”技能，使用该
//技能可以立即从位置 = t"反转“到z = -t.
//多多可以以任意顺序使用这些传送门，可以在任何时候使用“反转“技能(最多用一次，也可以不 用)，问用完所有传送|
//后，多多到初始位置: -0最远的距离为多少?
//输入描述
//第一行为一个正整数n(1 ≤n≤ 10'),
//第二行为n个整数 a1,a2,....,an(-104 ≤ ai ≤ 104)。
public class PortalGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] portals = new int[n];
        for (int i = 0; i < n; i++) {
            portals[i] = scanner.nextInt();
        }
        int maxDistance = calculateMaxDistance(portals);
        System.out.println(maxDistance);
        scanner.close();
    }

    public static int calculateMaxDistance(int[] portals) {
        int sum = 0;
        for (int portal : portals) {
            sum += portal;
        }

        int maxDist = Math.abs(sum);
        for (int portal : portals) {
            // 假设使用反转技能作用于当前传送门
            int newSum = sum - 2 * portal;
            maxDist = Math.max(maxDist, Math.abs(newSum));
        }
        return maxDist;
    }
}    