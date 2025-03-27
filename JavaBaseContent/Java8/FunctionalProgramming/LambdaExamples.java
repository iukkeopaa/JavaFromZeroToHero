import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExamples {
    public static void main(String[] args) {
        // 1. ʵ�� Runnable �ӿ�
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Running task: " + i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        // 2. ���ϵ� forEach ����
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));

        // 3. ʹ�� Predicate �ӿڹ��˼���
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Predicate<Integer> isEven = num -> num % 2 == 0;
        numbers.stream()
               .filter(isEven)
               .forEach(System.out::println);

        // 4. ʹ�� Consumer �ӿ�
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        names.forEach(printUpperCase);
    }
}    