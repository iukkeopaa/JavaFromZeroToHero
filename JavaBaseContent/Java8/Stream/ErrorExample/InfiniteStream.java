package ErrorExample;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        // ��������û�����ƻᵼ������ѭ��
        // Stream.generate(() -> Math.random()).forEach(System.out::println);

        // ʹ�� limit ����Ԫ������
        Stream.generate(() -> Math.random())
              .limit(5)
              .forEach(System.out::println);
    }
}
//ʹ�� Stream.generate() �� Stream.iterate() ����������ʱ�������������ƣ��ᵼ�³�����������ѭ����
//����취��ʹ�� limit() ����������������Ԫ������������ʹ�� findFirst()��findAny() ���ն˲�������������ʱֹͣ���Ĵ���