package ErrorExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConsumedOnce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();
        long count = stream.count();
        System.out.println("元素数量: " + count);

        try {
            // 尝试再次使用流，会抛出异常
            long sum = stream.mapToInt(Integer::intValue).sum();
            System.out.println("元素总和: " + sum);
        } catch (IllegalStateException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}
//解决办法：若需要多次使用流，可每次都从数据源重新获取流，或者将流的中间结果收集到一个新的集合中。