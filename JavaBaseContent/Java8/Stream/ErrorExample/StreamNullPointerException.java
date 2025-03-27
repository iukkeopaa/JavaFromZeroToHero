package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class StreamNullPointerException {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", null, "world");
        try {
            // ���׳���ָ���쳣
            strings.stream().map(String::toUpperCase).forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("�����쳣: " + e.getMessage());
        }
    }
}
//������������Ԫ��Ϊ null�����ܻ�������ָ���쳣��
//����취����������ǰ���˵� null Ԫ�أ�����ʹ�� Optional ���������Ϊ null ��Ԫ�ء�

