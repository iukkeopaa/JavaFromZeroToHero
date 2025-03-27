package MyCollections;

import java.util.HashMap;
import java.util.Map;

//��Ŀ����
//С�����һ������:��������׼��������λ�ϵ������������У�����: = 213�����ź������
//[123��132��231��312��321]����������213����Ϊ��û�н������ţ�������10��������|1]�����ź�� ���ֺ��Ե�
//ǰ���㡣
//�H�������С������ж��ٸ����ź������y��ʹ������λ֮����һ��������
//��������
//��һ��һ������T(1 ��<T �� 10%)����ʾ��������������ÿ�����ݸ�ʽΪ:
//-������?(1 �� ? �� 10��)����ʾ���������֡�
//�������
//����ÿ�����ݣ�ÿ�����һ����������ʾ�������������ָ�����
public class BatchUpdateWithHashBinary {

    public static void batchUpdate(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int index = -1;

        // ���ֲ��ҵ�һ��С�ڵ��� target ��λ��
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (index == -1) {
            return;
        }

        // �ù�ϣ��ͳ��Ƶ��
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int sum = 0;
        for (int i = index; i < n; i++) {
            int num = arr[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            sum += num;
        }

        // ��������
        int newSum = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (num > target) {
                newSum += target * freq;
            } else {
                newSum += num * freq;
            }
        }

        // ��������
        for (int i = index; i < n; i++) {
            arr[i] = Math.min(arr[i], target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 6, 4, 2};
        int target = 5;
        batchUpdate(arr, target);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}    