import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // 创建一个包含非空值的 Optional 对象
        String name = "John";
        Optional<String> optionalName = Optional.of(name);
        System.out.println("Optional 包含非空值: " + optionalName.isPresent());

        // 创建一个可能包含空值的 Optional 对象
        String nullName = null;
        Optional<String> optionalNullName = Optional.ofNullable(nullName);
        System.out.println("Optional 可能包含空值: " + optionalNullName.isPresent());

        // 获取 Optional 中的值，如果值存在
        if (optionalName.isPresent()) {
            String value = optionalName.get();
            System.out.println("获取 Optional 中的值: " + value);
        }

        // 如果值存在，执行操作
        optionalName.ifPresent(n -> System.out.println("执行操作: Hello, " + n));

        // 如果值不存在，提供默认值
        String result = optionalNullName.orElse("Default Name");
        System.out.println("如果值不存在，使用默认值: " + result);

        // 如果值不存在，执行其他操作
        optionalNullName.orElseGet(() -> {
            System.out.println("值不存在，执行其他操作");
            return "Generated Name";
        });

        // 如果值不存在，抛出异常
        try {
            optionalNullName.orElseThrow(() -> new IllegalArgumentException("值为空"));
        } catch (IllegalArgumentException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}    