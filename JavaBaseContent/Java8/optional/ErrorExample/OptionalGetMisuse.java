package ErrorExample;

import java.util.Optional;

//get() �������ڻ�ȡ Optional �е�ֵ������� Optional Ϊ�գ����׳� NoSuchElementException������ֱ��ʹ�� null Ȼ������ NullPointerException ���������ƣ�Υ����ʹ�� Optional �ĳ��ԡ�
public class OptionalGetMisuse {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty();
        try {
            // ���׳� NoSuchElementException
            String value = emptyOptional.get(); 
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("�����쳣: " + e.getMessage());
        }
    }
}
//����취��ʹ�� orElse()��orElseGet() �� orElseThrow() ��������� get() ���������磺