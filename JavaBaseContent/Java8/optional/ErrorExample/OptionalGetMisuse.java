package ErrorExample;

import java.util.Optional;

//get() 方法用于获取 Optional 中的值，但如果 Optional 为空，会抛出 NoSuchElementException，这与直接使用 null 然后引发 NullPointerException 本质上类似，违背了使用 Optional 的初衷。
public class OptionalGetMisuse {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty();
        try {
            // 会抛出 NoSuchElementException
            String value = emptyOptional.get(); 
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}
//解决办法：使用 orElse()、orElseGet() 或 orElseThrow() 方法来替代 get() 方法。例如：