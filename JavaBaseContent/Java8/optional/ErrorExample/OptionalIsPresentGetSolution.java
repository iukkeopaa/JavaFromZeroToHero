package ErrorExample;

import java.util.Optional;

public class OptionalIsPresentGetSolution {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("value");
        optional.ifPresent(System.out::println);
    }
}