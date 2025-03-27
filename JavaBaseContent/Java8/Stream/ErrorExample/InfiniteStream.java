package ErrorExample;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        // 无限流，没有限制会导致无限循环
        // Stream.generate(() -> Math.random()).forEach(System.out::println);

        // 使用 limit 限制元素数量
        Stream.generate(() -> Math.random())
              .limit(5)
              .forEach(System.out::println);
    }
}
//使用 Stream.generate() 或 Stream.iterate() 创建无限流时，若不进行限制，会导致程序陷入无限循环。
//解决办法：使用 limit() 方法限制无限流的元素数量，或者使用 findFirst()、findAny() 等终端操作在满足条件时停止流的处理。