package MyCollections;

import java.util.Arrays;

//有n名矿工，编号依次为1到n，他们按照编号由小到大的顺序，依次进入同一个矿道挖矿(即等到前一个人挖完矿下一个
//人才会去挖矿)。
//矿道里有m处矿，第j处矿的高度为6,(即j处高度|1,6;的位置都有1单位的矿物，其余位置没有矿物)，每个人拥有一个
//挖掘高度4，也即是说第i个人可以将高度在|1,;处的矿物全部挖掉。由于矿洞足够结实，底部的矿物挖空后，顶部共
//还有矿物，也不会掉下来。同一个位置的矿物挖掉之后就没有了。
//现在，每个人都会将自己能够挖到的矿物全挖掉，请你分别求解这n人挖到了多少单位的矿物。
public class MinerMining {
    public static int[] calculateMinedMinerals(int n, int m, int[] miningHeights, int[] mineHeights) {
        int[] mined = new int[n];
        boolean[] minedPositions = new boolean[1000001]; // 假设最大高度为 1000000

        for (int i = 0; i < n; i++) {
            int currentHeight = miningHeights[i];
            for (int j = 0; j < m; j++) {
                int mineHeight = mineHeights[j];
                if (mineHeight <= currentHeight &&!minedPositions[mineHeight]) {
                    mined[i]++;
                    minedPositions[mineHeight] = true;
                }
            }
        }
        return mined;
    }

    public static void main(String[] args) {
        int n = 3; // 矿工数量
        int m = 4; // 矿的数量
        int[] miningHeights = {2, 3, 1}; // 每个矿工的挖掘高度
        int[] mineHeights = {1, 2, 2, 3}; // 每处矿的高度

        int[] result = calculateMinedMinerals(n, m, miningHeights, mineHeights);
        System.out.println(Arrays.toString(result));
    }
}    