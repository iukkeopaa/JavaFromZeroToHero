package ErrorExample;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        List<Integer> smallNumbers = Arrays.asList(1, 2, 3);
        long startTime = System.currentTimeMillis();
        // 对于小数据量，顺序流可能更快
        smallNumbers.stream().mapToInt(Integer::intValue).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("顺序流耗时: " + (endTime - startTime) + " 毫秒");

        startTime = System.currentTimeMillis();
        smallNumbers.parallelStream().mapToInt(Integer::intValue).sum();
        endTime = System.currentTimeMillis();
        System.out.println("并行流耗时: " + (endTime - startTime) + " 毫秒");
    }
}

//并行流并非在所有情况下都能提升性能，在数据量小或者操作本身简单时，使用并行流反而会因线程创建和管理的开销导致性能下降。
//解决办法：使用并行流前，要先评估数据量和操作的复杂度，可通过性能测试来确定是否使用并行流。同时，要确保操作是线程安全的。