package ErrorExample;

import java.util.Optional;

//����Ƕ�� Optional ��ʹ����Ŀɶ��ԺͿ�ά���Ա��ô����߼���ø��ӣ��������͵��ԡ�
public class OptionalNesting {
    public static void main(String[] args) {
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("value"));
        // Ƕ�׵� Optional ������
        nestedOptional.flatMap(opt -> opt).ifPresent(System.out::println); 
    }
}
//����취��ʹ�� flatMap() ���������� Optional ��Ƕ�ף����߽����ӵ��߼���ֳɶ���򵥵ķ�����