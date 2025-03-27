import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // 初始化一个整数列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 过滤操作：筛选出偶数
        List<Integer> evenNumbers = numbers.stream()
               .filter(n -> n % 2 == 0)
               .collect(Collectors.toList());
        System.out.println("偶数列表: " + evenNumbers);

        // 映射操作：将每个数乘以 2
        List<Integer> doubledNumbers = numbers.stream()
               .map(n -> n * 2)
               .collect(Collectors.toList());
        System.out.println("每个数乘以 2 后的列表: " + doubledNumbers);

        // 排序操作：将列表按降序排序
        List<Integer> sortedNumbers = numbers.stream()
               .sorted((a, b) -> b - a)
               .collect(Collectors.toList());
        System.out.println("降序排序后的列表: " + sortedNumbers);

        // 归约操作：计算所有数的和
        Optional<Integer> sum = numbers.stream()
               .reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("所有数的和: " + sum.get());
        }

        // 匹配操作：检查是否所有数都大于 0
        boolean allGreaterThanZero = numbers.stream()
               .allMatch(n -> n > 0);
        System.out.println("所有数都大于 0: " + allGreaterThanZero);
    }

    //
}    