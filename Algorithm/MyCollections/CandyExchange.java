package MyCollections;

import java.util.Arrays;

//��n��С����Χ��һȦ���������ǵı�ŷֱ�Ϊ1,2,��,n�����Ϊi����Ϊi+1(1<=i<n)��С���ѻ�Ϊ���ڹ�ϵ���ر�أ����Ϊ1����Ϊn��С����Ҳ��Ϊ���ڹ�ϵ��
//ÿ��С���Ѷ�����һЩ�ǹ�[a_1,a_2,��,a_n]��a_i��ʾ��i��С���Ѵ����ǹ�������������ʦ����������һ����������Ϸ��ÿ����ʦ����������ʱ�����е�С���Ѷ��Ὣ�Լ���ǰ���ϵ��ǹ��ָ����ڵ�С���ѣ���������ǹ���������ż������ƽ�ָ������������ڵ�С���ѣ���������ǹ�����������������ô�Լ�����1���ǹ����ٽ�ʣ�µ��ǹ����ָ������������ڵ�С���ѡ�
//����ʦ����k�Ρ���������ÿ��С������Ҫ�����Լ����ϵ��ǹ�������
//���統n=4��k=3ʱ������һ��ʼС���Ѵ����ǹ�����Ϊ[2,3,5,4]����ô����3�Ρ����������ǹ��������Ϊ��[2,3,5,4]=>[3,4,4,3]=>[4,3,3,4]=>[3,4,4,3]��
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