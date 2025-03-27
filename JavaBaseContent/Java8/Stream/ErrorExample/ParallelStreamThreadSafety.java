package ErrorExample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStreamThreadSafety {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // ʹ�� AtomicInteger ��֤�̰߳�ȫ
        AtomicInteger sum = new AtomicInteger(0);
        numbers.parallelStream().forEach(num -> sum.addAndGet(num));
        System.out.println("Ԫ���ܺ�: " + sum);
    }
}
//�������ڶ��̻߳�����ִ�в������������漰����ɱ�״̬���ͻ������̰߳�ȫ���⡣