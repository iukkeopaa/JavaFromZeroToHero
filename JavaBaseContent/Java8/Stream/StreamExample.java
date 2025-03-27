import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // ��ʼ��һ�������б�
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ���˲�����ɸѡ��ż��
        List<Integer> evenNumbers = numbers.stream()
               .filter(n -> n % 2 == 0)
               .collect(Collectors.toList());
        System.out.println("ż���б�: " + evenNumbers);

        // ӳ���������ÿ�������� 2
        List<Integer> doubledNumbers = numbers.stream()
               .map(n -> n * 2)
               .collect(Collectors.toList());
        System.out.println("ÿ�������� 2 ����б�: " + doubledNumbers);

        // ������������б���������
        List<Integer> sortedNumbers = numbers.stream()
               .sorted((a, b) -> b - a)
               .collect(Collectors.toList());
        System.out.println("�����������б�: " + sortedNumbers);

        // ��Լ�����������������ĺ�
        Optional<Integer> sum = numbers.stream()
               .reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("�������ĺ�: " + sum.get());
        }

        // ƥ�����������Ƿ������������� 0
        boolean allGreaterThanZero = numbers.stream()
               .allMatch(n -> n > 0);
        System.out.println("������������ 0: " + allGreaterThanZero);
    }

    //
}    