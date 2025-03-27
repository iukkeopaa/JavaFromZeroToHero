package MyCollections;

import java.util.Scanner;

//小A和小B都是搬砖人，因为各自的身体素质不同，所以他们为自己制定了不同的小目标。小A可以一次搬a1块砖，但是每搬一次就要休息b1分钟，他的目标是一天搬c1块砖;同样的，小B可以一次搬a2块砖，但是每搬一次就要休息b2分钟，他的目标是一天搬c2块砖。
//每个人情况不同，只要完成自己的目标就好，已知某天小A和小B同时开始搬砖，请问他们谁先完成自己的目标？如果是小A则输出‘A’，如果是小B则输出‘B’，如果两个人同时完成，则输出‘A&B’。

//输入样例
//2
//7 9 19 9 1 89
//7 9 95 4 5 9
public class BrickMovingComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入小 A 的相关信息
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        // 输入小 B 的相关信息
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        // 计算小 A 完成目标所需时间
        int timesA = (int) Math.ceil((double) c1 / a1);
        int timeA = (timesA - 1) * b1;

        // 计算小 B 完成目标所需时间
        int timesB = (int) Math.ceil((double) c2 / a2);
        int timeB = (timesB - 1) * b2;

        // 判断谁先完成目标
        if (timeA < timeB) {
            System.out.println("A");
        } else if (timeA > timeB) {
            System.out.println("B");
        } else {
            System.out.println("A&B");
        }
    }
}    