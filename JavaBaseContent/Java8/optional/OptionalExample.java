import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // ����һ�������ǿ�ֵ�� Optional ����
        String name = "John";
        Optional<String> optionalName = Optional.of(name);
        System.out.println("Optional �����ǿ�ֵ: " + optionalName.isPresent());

        // ����һ�����ܰ�����ֵ�� Optional ����
        String nullName = null;
        Optional<String> optionalNullName = Optional.ofNullable(nullName);
        System.out.println("Optional ���ܰ�����ֵ: " + optionalNullName.isPresent());

        // ��ȡ Optional �е�ֵ�����ֵ����
        if (optionalName.isPresent()) {
            String value = optionalName.get();
            System.out.println("��ȡ Optional �е�ֵ: " + value);
        }

        // ���ֵ���ڣ�ִ�в���
        optionalName.ifPresent(n -> System.out.println("ִ�в���: Hello, " + n));

        // ���ֵ�����ڣ��ṩĬ��ֵ
        String result = optionalNullName.orElse("Default Name");
        System.out.println("���ֵ�����ڣ�ʹ��Ĭ��ֵ: " + result);

        // ���ֵ�����ڣ�ִ����������
        optionalNullName.orElseGet(() -> {
            System.out.println("ֵ�����ڣ�ִ����������");
            return "Generated Name";
        });

        // ���ֵ�����ڣ��׳��쳣
        try {
            optionalNullName.orElseThrow(() -> new IllegalArgumentException("ֵΪ��"));
        } catch (IllegalArgumentException e) {
            System.out.println("�����쳣: " + e.getMessage());
        }
    }
}    