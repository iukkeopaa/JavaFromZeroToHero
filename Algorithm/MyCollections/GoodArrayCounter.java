package MyCollections;

import java.util.TreeSet;

//������֪��һ������Ϊn��nΪ�������������λ������������±�Ϊ�������֡�
//��С�����֣���Щ��Ϊ����n�����鼴ʹ���������±�Ϊ����������Ȼ����������λ�������������������ʵ���֯��
//Ϊ ������"��
//����С����һ������Ϊn������p������֪��p���ж��ٸ�������������ɵ����鶼�ǡ�������"��
//(���ж��ٶ�l,?(1 ��l��r�� n),ͬʱ, -l+ 1������,����R,p +1,��,P��һ�������顣)
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
        System.out.println("�������������: " + result);
    }
}    