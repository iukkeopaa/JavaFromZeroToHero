package ErrorExample;

import java.util.Optional;

//过度嵌套 Optional 会使代码的可读性和可维护性变差，让代码逻辑变得复杂，难以理解和调试。
public class OptionalNesting {
    public static void main(String[] args) {
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("value"));
        // 嵌套的 Optional 处理复杂
        nestedOptional.flatMap(opt -> opt).ifPresent(System.out::println); 
    }
}
//解决办法：使用 flatMap() 方法来避免 Optional 的嵌套，或者将复杂的逻辑拆分成多个简单的方法。