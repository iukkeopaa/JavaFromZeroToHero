package ErrorExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConsumedOnce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();
        long count = stream.count();
        System.out.println("Ԫ������: " + count);

        try {
            // �����ٴ�ʹ���������׳��쳣
            long sum = stream.mapToInt(Integer::intValue).sum();
            System.out.println("Ԫ���ܺ�: " + sum);
        } catch (IllegalStateException e) {
            System.out.println("�����쳣: " + e.getMessage());
        }
    }
}
//����취������Ҫ���ʹ��������ÿ�ζ�������Դ���»�ȡ�������߽������м����ռ���һ���µļ����С�