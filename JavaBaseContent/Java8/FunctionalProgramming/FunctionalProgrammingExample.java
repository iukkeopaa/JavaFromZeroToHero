import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // 1. Lambda ���ʽʾ��
        // ʵ�� Runnable �ӿ�
        Runnable runnable = () -> System.out.println("Running using Lambda");
        new Thread(runnable).start();

        // 2. ��������ʾ��
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // ��̬��������
        names.forEach(System.out::println);

        // 3. Stream API ʾ��
        // ���˺�ӳ�����
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquared = numbers.stream()
               .filter(n -> n % 2 == 0) // ����ż��
               .map(n -> n * n) // ��ż������ƽ��
               .collect(Collectors.toList());
        System.out.println("Even numbers squared: " + evenSquared);

        // 4. ʹ�ú���ʽ�ӿ�ʾ��
        // Predicate ʾ��
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // Function ʾ��
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Square of 5: " + square.apply(5));

        // Consumer ʾ��
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello");
    }
}    