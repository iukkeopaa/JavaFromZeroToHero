package MyCollections;

import java.util.Arrays;

//有n个小朋友围成一圈，假设他们的编号分别为1,2,…,n，编号为i与编号为i+1(1<=i<n)的小朋友互为相邻关系，特别地，编号为1与编号为n的小朋友也互为相邻关系。
//每个小朋友都带了一些糖果[a_1,a_2,…,a_n]，a_i表示第i个小朋友带的糖果数量。现在老师带着他们做一个这样的游戏：每当老师喊“交换”时，所有的小朋友都会将自己当前手上的糖果分给相邻的小朋友：如果手上糖果的数量是偶数，则平分给左右两个相邻的小朋友；如果手上糖果的数量是奇数，那么自己留下1个糖果，再将剩下的糖果评分给左右两个相邻的小朋友。
//在老师喊了k次“交换”后，每个小朋友需要报告自己手上的糖果数量。
//例如当n=4且k=3时，假设一开始小朋友带的糖果数量为[2,3,5,4]，那么进行3次“交换”后糖果数量情况为：[2,3,5,4]=>[3,4,4,3]=>[4,3,3,4]=>[3,4,4,3]。
public class CandyExchange {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        int[] candies = {2, 3, 5, 4};
        int[] result = exchangeCandies(n, k, candies);
        System.out.println(Arrays.toString(result));
    }

    public static int[] exchangeCandies(int n, int k, int[] candies) {
        for (int i = 0; i < k; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int left = (j - 1 + n) % n;
                int right = (j + 1) % n;
                int leftShare = getShare(candies[left]);
                int rightShare = getShare(candies[right]);
                temp[j] = leftShare + rightShare;
            }
            candies = temp;
        }
        return candies;
    }

    public static int getShare(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return (num - 1) / 2;
        }
    }
}    