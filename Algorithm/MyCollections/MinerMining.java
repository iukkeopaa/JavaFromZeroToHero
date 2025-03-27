package MyCollections;

import java.util.Arrays;

//��n���󹤣��������Ϊ1��n�����ǰ��ձ����С�����˳�����ν���ͬһ������ڿ�(���ȵ�ǰһ�����������һ��
//�˲Ż�ȥ�ڿ�)��
//�������m���󣬵�j����ĸ߶�Ϊ6,(��j���߶�|1,6;��λ�ö���1��λ�Ŀ������λ��û�п���)��ÿ����ӵ��һ��
//�ھ�߶�4��Ҳ����˵��i���˿��Խ��߶���|1,;���Ŀ���ȫ���ڵ������ڿ��㹻��ʵ���ײ��Ŀ����ڿպ󣬶�����
//���п��Ҳ�����������ͬһ��λ�õĿ����ڵ�֮���û���ˡ�
//���ڣ�ÿ���˶��Ὣ�Լ��ܹ��ڵ��Ŀ���ȫ�ڵ�������ֱ������n���ڵ��˶��ٵ�λ�Ŀ��
public class MinerMining {
    public static int[] calculateMinedMinerals(int n, int m, int[] miningHeights, int[] mineHeights) {
        int[] mined = new int[n];
        boolean[] minedPositions = new boolean[1000001]; // �������߶�Ϊ 1000000

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
        int n = 3; // ������
        int m = 4; // �������
        int[] miningHeights = {2, 3, 1}; // ÿ���󹤵��ھ�߶�
        int[] mineHeights = {1, 2, 2, 3}; // ÿ����ĸ߶�

        int[] result = calculateMinedMinerals(n, m, miningHeights, mineHeights);
        System.out.println(Arrays.toString(result));
    }
}    