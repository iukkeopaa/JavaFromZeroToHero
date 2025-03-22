package TheBeautyofProgramming.ch2;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalCheck {
    public static boolean isSourceInTargets(Interval source, List<Interval> targets) {
        if (targets.isEmpty()) {
            return false;
        }
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;

        for (Interval target : targets) {
            minStart = Math.min(minStart, target.start);
            maxEnd = Math.max(maxEnd, target.end);
        }

        return source.start >= minStart && source.end <= maxEnd;
    }

    public static void main(String[] args) {
        Interval source = new Interval(1, 6);
        List<Interval> targets = new ArrayList<>();
        targets.add(new Interval(2, 3));
        targets.add(new Interval(1, 2));
        targets.add(new Interval(3, 9));

        boolean result = isSourceInTargets(source, targets);
        System.out.println("源区间是否在目标区间内: " + result);
    }
}    