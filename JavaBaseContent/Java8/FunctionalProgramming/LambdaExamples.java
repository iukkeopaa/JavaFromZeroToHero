import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExamples {
    public static void main(String[] args) {
        // 1. 实现 Runnable 接口
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Running task: " + i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        // 2. 集合的 forEach 方法
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));

        // 3. 使用 Predicate 接口过滤集合
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Predicate<Integer> isEven = num -> num % 2 == 0;
        numbers.stream()
               .filter(isEven)
               .forEach(System.out::println);

        // 4. 使用 Consumer 接口
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        names.forEach(printUpperCase);
    }
}    