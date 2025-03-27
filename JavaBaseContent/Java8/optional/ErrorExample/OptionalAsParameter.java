package ErrorExample;

import java.util.Optional;

//把 Optional 用作方法参数会让方法签名变得复杂，降低代码的可读性，并且调用者还需要手动创建 Optional 对象，增加了不必要的代码量。
public class OptionalAsParameter {
    public static void processValue(Optional<String> value) {
        value.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        // 调用者需要手动创建 Optional 对象
        processValue(Optional.ofNullable("test")); 
    }
}

//解决办法：优先使用 null 作为参数传递，在方法内部使用 Optional.ofNullable() 来处理可能的 null 值