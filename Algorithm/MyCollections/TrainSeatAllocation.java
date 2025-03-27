package MyCollections;

import java.util.*;

//一列具有 m 个座位的火车，从起点到终点共停靠, 个站点，站点编号从0到n -1。发车前有x名乘客预定了座位，因
//为预定数量可能超出座位数，为了保证效率最大化，请计算如何分配才能是座位利用率最大，并输出最大的座位利用
//数。
// 定义一个类来表示乘客的预订信息
class Reservation {
    int start;
    int end;

    // 构造函数，用于初始化预订信息
    Reservation(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class TrainSeatAllocation {
    // 计算最大座位利用率的方法
    public static int maxSeatUtilization(int m, int n, Reservation[] reservations) {
        // 对预订信息按照上车点和下车点进行排序
        Arrays.sort(reservations, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        // 用于存储每个座位的结束时间
        PriorityQueue<Integer> occupiedSeats = new PriorityQueue<>();
        int utilization = 0;

        // 遍历每个预订信息
        for (Reservation reservation : reservations) {
            // 移除已经下车的乘客所占用的座位
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek() <= reservation.start) {
                occupiedSeats.poll();
            }

            // 如果还有空位，分配座位
            if (occupiedSeats.size() < m) {
                occupiedSeats.offer(reservation.end);
                utilization += reservation.end - reservation.start;
            } else {
                // 尝试找到最早结束的座位并更新
                if (!occupiedSeats.isEmpty() && occupiedSeats.peek() < reservation.end) {
                    occupiedSeats.poll();
                    occupiedSeats.offer(reservation.end);
                    utilization += reservation.end - reservation.start;
                }
            }
        }

        return utilization;
    }

    public static void main(String[] args) {
        int m = 3; // 座位数
        int n = 5; // 站点数
        Reservation[] reservations = {
                new Reservation(0, 2),
                new Reservation(1, 3),
                new Reservation(2, 4),
                new Reservation(3, 5)
        };

        int maxUtilization = maxSeatUtilization(m, n, reservations);
        System.out.println("最大座位利用数: " + maxUtilization);
    }
}