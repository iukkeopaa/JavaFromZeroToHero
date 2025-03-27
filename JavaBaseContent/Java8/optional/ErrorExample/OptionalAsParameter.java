package ErrorExample;

import java.util.Optional;

//�� Optional ���������������÷���ǩ����ø��ӣ����ʹ���Ŀɶ��ԣ����ҵ����߻���Ҫ�ֶ����� Optional ���������˲���Ҫ�Ĵ�������
public class OptionalAsParameter {
    public static void processValue(Optional<String> value) {
        value.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        // ��������Ҫ�ֶ����� Optional ����
        processValue(Optional.ofNullable("test")); 
    }
}

//����취������ʹ�� null ��Ϊ�������ݣ��ڷ����ڲ�ʹ�� Optional.ofNullable() ��������ܵ� null ֵ