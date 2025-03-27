package ErrorExample;

import java.util.Optional;

//��ʹ�� isPresent() ��� Optional �Ƿ���ֵ��Ȼ���ٵ��� get() ����������������ֱ��ʹ�� null ���û��̫�����𣬲��������˴��������ȡ�
public class OptionalIsPresentGet {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("value");
        if (optional.isPresent()) {
            String value = optional.get();
            System.out.println(value);
        }
    }
}
//����취��ֱ��ʹ�� ifPresent()��orElse() �ȷ��������� Optional������ʹ�� isPresent() �� get() ����ϡ����磺