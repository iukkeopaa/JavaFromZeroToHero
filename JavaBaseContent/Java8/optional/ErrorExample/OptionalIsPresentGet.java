package ErrorExample;

import java.util.Optional;

//先使用 isPresent() 检查 Optional 是否有值，然后再调用 get() 方法，这种做法与直接使用 null 检查没有太大区别，并且增加了代码的冗余度。
public class OptionalIsPresentGet {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("value");
        if (optional.isPresent()) {
            String value = optional.get();
            System.out.println(value);
        }
    }
}
//解决办法：直接使用 ifPresent()、orElse() 等方法来处理 Optional，避免使用 isPresent() 和 get() 的组合。例如：