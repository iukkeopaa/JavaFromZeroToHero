package MyCollections;

//��Ŀ����
//С����Ϊһ�����������������ҽ���:�����:��ͣ����2��ֱ��:������2ʱֹͣ����ʱzǡ�õ���1.
//���һ������������������ֵΪ:���ϲ����г���2�Ĵ�����
//����һ��������������������ֵΪ0��
//����С����һ������Ϊn������a������֪��a����������������ĺ͵�����ֵ֮���Ƕ��٣����������һ��ɡ�
//��ʽ����:������x������ֵΪf()���������
//��������f(a +au+1+...+ar)
//(����a + a1+1 + ...a,��ʾa������[l,,]��һ�����������Ԫ��֮��)
public class BeautifulNumberSum {
    // ����һ����������ֵ
    public static int beautyValue(int num) {
        int count = 0;
        while (num % 2 == 0) {
            num /= 2;
            count++;
        }
        return num == 1 ? count : 0;
    }

    // ������������������������͵�����ֵ֮��
    public static int totalBeautyValue(int[] a) {
        int n = a.length;
        int[] prefixSum = new int[n + 1];
        // ����ǰ׺��
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }
        int total = 0;
        // �������п��ܵ�������
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int sum = prefixSum[r + 1] - prefixSum[l];
                total += beautyValue(sum);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int result = totalBeautyValue(a);
        System.out.println("��������������͵�����ֵ֮��Ϊ: " + result);
    }
}    