import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // 1. Lambda 表达式示例
        // 实现 Runnable 接口
        Runnable runnable = () -> System.out.println("Running using Lambda");
        new Thread(runnable).start();

        // 2. 方法引用示例
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // 静态方法引用
        names.forEach(System.out::println);

        // 3. Stream API 示例
        // 过滤和映射操作
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquared = numbers.stream()
               .filter(n -> n % 2 == 0) // 过滤偶数
               .map(n -> n * n) // 对偶数进行平方
               .collect(Collectors.toList());
        System.out.println("Even numbers squared: " + evenSquared);

        // 4. 使用函数式接口示例
        // Predicate 示例
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // Function 示例
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Square of 5: " + square.apply(5));

        // Consumer 示例
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello");
    }
}    