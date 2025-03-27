package ErrorExample;

import java.util.Optional;

public class OptionalNestingSolution {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("value");
        Optional<String> result = optional;
        result.ifPresent(System.out::println);
    }
}