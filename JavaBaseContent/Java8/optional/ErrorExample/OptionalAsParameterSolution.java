package ErrorExample;

import java.util.Optional;

public class OptionalAsParameterSolution {
    public static void processValue(String value) {
        Optional.ofNullable(value).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        processValue("test");
    }
}