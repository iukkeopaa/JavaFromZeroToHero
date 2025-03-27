package MyCollections;

//С�춨��һ���ַ�����ȨֵΪ���ַ������ȳ����ַ�������ĸ�������������磬"abacb"�ļ�ֵΪ5*3=15��
//С���õ���һ���ַ�������׼�������ַ����зֳ�

//k���Ӵ�������

//k���Ӵ���˳��ƴ��һ�𼴿ɵõ�ԭ������С��ϣ���зֺ���

//k���Ӵ������Ȩֵ������С�����ܰ��С�����㲻��Ҫ����һ��������ֻ��Ҫ����������

//k���Ӵ������Ȩֵ���ɡ�
//�ַ���������Сд��ĸ���ҳ��Ȳ�����500000��
//k
//kΪ�������ַ������ȵ���������
public class StringWeightSplit {
    public static int minMaxWeight(String s, int k) {
        int left = 1;
        int right = s.length() * 26;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(s, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canSplit(String s, int maxWeight, int k) {
        int count = 1;
        int weight = 0;
        java.util.HashSet<Character> charSet = new java.util.HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charSet.add(c);
            weight++;
            if (weight * charSet.size() > maxWeight) {
                count++;
                weight = 1;
                charSet = new java.util.HashSet<>();
                charSet.add(c);
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
        System.out.println(minMaxWeight(s, k)); 
    }
}