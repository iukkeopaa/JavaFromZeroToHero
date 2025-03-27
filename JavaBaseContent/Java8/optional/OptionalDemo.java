import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		/**
		 * optional����һ��null����
		 */
        Optional<String> optional=Optional.ofNullable(null);
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse("orElse"));
        System.out.println(optional.orElseGet(()->"orElseGet"));
        System.out.println(optional.map(e->"map"+e).orElse("map default"));
        System.out.println(optional.flatMap(f->Optional.of("test")));
        System.out.println("==================================");
        /**
         * optional����һ���ǿն���
         */
        optional=Optional.of("hello word");
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse("orElse default"));
        System.out.println(optional.filter(s->s.startsWith("hello")));
        System.out.println(optional.flatMap(f->Optional.of(" flatMap ")));
        System.out.println(optional.get());
	}
}