package ErrorExample;

import java.util.Optional;

public class OptionalGetSolution {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty();
        String value = emptyOptional.orElse("Ĭ��ֵ");
        System.out.println(value);
    }
}