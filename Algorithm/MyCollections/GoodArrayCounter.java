package MyCollections;

import java.util.TreeSet;

//众所周知，一个长度为n，n为奇数的数组的中位数是其排序后下标为“的数字。
//但小美发现，有些长为奇数n的数组即使不排序，其下标为“的数字依然是其数组中位数，他将满足这样性质的数织…
//为 好数组"。
//现在小美有一个长度为n的排列p，他想知道p中有多少个连续的区间组成的数组都是”好数组"。
//(即有多少对l,?(1 ≤l≤r≤ n),同时, -l+ 1是奇数,满足R,p +1,”,P是一个好数组。)
class GoodArrayCounter {
    public static int countGoodArrays(int[] p) {
        int n = p.length;
        int count = 0;
        for (int l = 0; l < n; l++) {
            TreeSet<Integer> left = new TreeSet<>((a, b) -> p[a] != p[b] ? p[a] - p[b] : a - b);
            TreeSet<Integer> right = new TreeSet<>((a, b) -> p[a] != p[b] ? p[a] - p[b] : a - b);
            for (int r = l; r < n; r++) {
                if (left.size() == right.size()) {
                    right.add(r);
                    left.add(right.pollFirst());
                } else {
                    left.add(r);
                    right.add(left.pollLast());
                }
                if ((r - l + 1) % 2 == 1) {
                    int medianIndex = left.last();
                    if (medianIndex == l + (r - l) / 2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4, 5};
        int result = countGoodArrays(p);
        System.out.println("好数组的数量是: " + result);
    }
}    