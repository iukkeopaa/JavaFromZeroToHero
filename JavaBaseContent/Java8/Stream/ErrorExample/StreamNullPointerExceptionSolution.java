package ErrorExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamNullPointerExceptionSolution {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", null, "world");
        strings.stream()
              .filter(s -> s != null)
              .map(String::toUpperCase)
              .forEach(System.out::println);

        // 使用 Optional 处理
        strings.stream()
              .map(Optional::ofNullable)
              .filter(Optional::isPresent)
              .map(Optional::get)
              .map(String::toUpperCase)
              .forEach(System.out::println);
    }
}