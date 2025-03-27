package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class StreamNullPointerException {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", null, "world");
        try {
            // 会抛出空指针异常
            strings.stream().map(String::toUpperCase).forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}
//在流操作里，如果元素为 null，可能会引发空指针异常。
//解决办法：在流操作前过滤掉 null 元素，或者使用 Optional 来处理可能为 null 的元素。

