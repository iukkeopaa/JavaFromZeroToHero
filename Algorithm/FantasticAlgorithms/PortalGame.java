package FantasticAlgorithms;

//�������һ����������Ϸ��
//��Ϸ��ʼʱ�����һά�����:=0�������м��������ţ�ÿ�������Ŷ���һ������ֵ4:������
//ʹ�øô����Ŵӡ� = tλ�ô��͵�:; =t+@��������������Ʒ��ֻ��ʹ��һ�Ρ�ͬʱ������һ ������ת�����ܣ�ʹ�ø�
//���ܿ���������λ��2 = t����ת����z = -t.
//�����1��nʹ����Щ�����ţ��������κ�ʱ��ʹ�á���ת������(�����һ�Σ�Ҳ���Բ� ��)�����������д����ź�
//��ൽ��ʼλ��: -0��Զ�ľ���Ϊ����?
public class PortalGame {
    /**
     * ������ʹ�ô����ź�����ʼλ�õ���Զ����
     * @param portals �����ŵĴ���ֵ����
     * @return ��Զ����
     */
    public static int maxDistance(int[] portals) {
        // �����ŵ�����
        int n = portals.length;
        // ǰ׺�����飬���ڿ��ټ��������
        int[] prefixSum = new int[n + 1];

        // ����ǰ׺��
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + portals[i];
        }

        // ��ʼ��������Ϊ��ʹ�÷�ת���ܵľ���
        int maxDist = Math.abs(prefixSum[n]);

        // ������ÿ��λ��ʹ�÷�ת����
        for (int i = 0; i <= n; i++) {
            // ����ʹ�÷�ת���ܺ�ľ���
            int currentDist = Math.abs(prefixSum[n] - 2 * prefixSum[i]);
            // ����������
            maxDist = Math.max(maxDist, currentDist);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        // ʾ�������Ŵ���ֵ����
        int[] portals = {1, -2, 3};
        // ���� maxDistance ����������Զ����
        int result = maxDistance(portals);
        // ������
        System.out.println("��ൽ��ʼλ�õ���Զ������: " + result);
    }
}
    