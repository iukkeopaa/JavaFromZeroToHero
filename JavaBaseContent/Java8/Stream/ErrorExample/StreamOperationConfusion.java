package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class StreamOperationConfusion {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // �м��������ִ��
        numbers.stream().map(num -> {
            System.out.println("����Ԫ��: " + num);
            return num * 2;
        });

        // �����ն˲������м�����Ż�ִ��
        numbers.stream().map(num -> {
            System.out.println("����Ԫ��: " + num);
            return num * 2;
        }).forEach(System.out::println);
    }
}
///��������Ϊ�м�������ն˲������м�����Ƕ��Եģ�ֻ�����ն˲�������ʱ�Ż�ִ�С���ֻ�����м�������������ն˲������м��������ִ�С�