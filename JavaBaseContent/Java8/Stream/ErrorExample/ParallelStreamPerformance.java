package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        List<Integer> smallNumbers = Arrays.asList(1, 2, 3);
        long startTime = System.currentTimeMillis();
        // ����С��������˳�������ܸ���
        smallNumbers.stream().mapToInt(Integer::intValue).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("˳������ʱ: " + (endTime - startTime) + " ����");

        startTime = System.currentTimeMillis();
        smallNumbers.parallelStream().mapToInt(Integer::intValue).sum();
        endTime = System.currentTimeMillis();
        System.out.println("��������ʱ: " + (endTime - startTime) + " ����");
    }
}

//��������������������¶����������ܣ���������С���߲��������ʱ��ʹ�ò��������������̴߳����͹���Ŀ������������½���
//����취��ʹ�ò�����ǰ��Ҫ�������������Ͳ����ĸ��Ӷȣ���ͨ�����ܲ�����ȷ���Ƿ�ʹ�ò�������ͬʱ��Ҫȷ���������̰߳�ȫ�ġ�