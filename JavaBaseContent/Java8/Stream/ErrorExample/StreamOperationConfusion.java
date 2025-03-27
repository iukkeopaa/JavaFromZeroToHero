package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class StreamOperationConfusion {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 中间操作不会执行
        numbers.stream().map(num -> {
            System.out.println("处理元素: " + num);
            return num * 2;
        });

        // 调用终端操作，中间操作才会执行
        numbers.stream().map(num -> {
            System.out.println("处理元素: " + num);
            return num * 2;
        }).forEach(System.out::println);
    }
}
///流操作分为中间操作和终端操作，中间操作是惰性的，只有在终端操作调用时才会执行。若只调用中间操作而不调用终端操作，中间操作不会执行。