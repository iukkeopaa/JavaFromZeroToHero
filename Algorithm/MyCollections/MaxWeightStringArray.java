package MyCollections;

import java.util.*;

//��Ŀ����
//С���õ�һ������Ϊn���ַ������飬ÿ���ַ��������ɸ�Сд��ĸ��ɡ�
//����һ���ַ��������ȨֵΪ�������ͬ�ַ��������䳤�ȡ�
//����֪������ǡ��ɾ��һ�������ǿ����䣬ʣ�µ��ַ��������Ȩֵ����Ƕ���,
//��������
//��һ��һ������n(2 �� n�� 10��)����ʾ�ַ�������ĳ��ȡ�
//������n �У�ÿ��һ���ַ�������֤����Сд��ĸ��ɡ�
//��֤�����ַ����ĳ���֮�Ͳ�����106
//�������
//����������ʾɾ��һ�������ǿ������ʣ�µ��ַ��������Ȩֵ����Ƕ��١�
public class MaxWeightStringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        scanner.close();

        int maxWeight = calculateMaxWeight(strings);
        System.out.println(maxWeight);
    }

    public static int calculateMaxWeight(String[] strings) {
        // �洢ÿ���ַ�����Ӧ�������γ����б�
        Map<String, List<Integer>> segments = new HashMap<>();
        int i = 0;
        while (i < strings.length) {
            String current = strings[i];
            int count = 1;
            i++;
            while (i < strings.length && strings[i].equals(current)) {
                count++;
                i++;
            }
            segments.computeIfAbsent(current, k -> new ArrayList<>()).add(count);
        }

        int maxWeight = 0;
        // ����ÿ���ַ�����Ӧ�������γ����б�
        for (List<Integer> lengths : segments.values()) {
            if (lengths.size() > 1) {
                // ��������
                lengths.sort(Collections.reverseOrder());
                // ȡǰ����ĳ�����Ӳ��������Ȩֵ
                maxWeight = Math.max(maxWeight, lengths.get(0) + lengths.get(1));
            }
        }

        // ���������ַ�������ͬ�����
        boolean allSame = true;
        for (i = 1; i < strings.length; i++) {
            if (!strings[i].equals(strings[0])) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            maxWeight = Math.max(maxWeight, strings.length - 1);
        }

        return maxWeight;
    }
}    