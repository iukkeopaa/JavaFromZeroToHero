package ErrorExample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStreamThreadSafety {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 使用 AtomicInteger 保证线程安全
        AtomicInteger sum = new AtomicInteger(0);
        numbers.parallelStream().forEach(num -> sum.addAndGet(num));
        System.out.println("元素总和: " + sum);
    }
}
//并行流在多线程环境下执行操作，若操作涉及共享可变状态，就会引发线程安全问题。