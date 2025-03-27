package MyCollections;

import java.util.*;

//һ�о��� m ����λ�Ļ𳵣�����㵽�յ㹲ͣ��, ��վ�㣬վ���Ŵ�0��n -1������ǰ��x���˿�Ԥ������λ����
//ΪԤ���������ܳ�����λ����Ϊ�˱�֤Ч����󻯣��������η����������λ��������󣬲����������λ����
//����
// ����һ��������ʾ�˿͵�Ԥ����Ϣ
class Reservation {
    int start;
    int end;

    // ���캯�������ڳ�ʼ��Ԥ����Ϣ
    Reservation(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class TrainSeatAllocation {
    // ���������λ�����ʵķ���
    public static int maxSeatUtilization(int m, int n, Reservation[] reservations) {
        // ��Ԥ����Ϣ�����ϳ�����³����������
        Arrays.sort(reservations, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        // ���ڴ洢ÿ����λ�Ľ���ʱ��
        PriorityQueue<Integer> occupiedSeats = new PriorityQueue<>();
        int utilization = 0;

        // ����ÿ��Ԥ����Ϣ
        for (Reservation reservation : reservations) {
            // �Ƴ��Ѿ��³��ĳ˿���ռ�õ���λ
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek() <= reservation.start) {
                occupiedSeats.poll();
            }

            // ������п�λ��������λ
            if (occupiedSeats.size() < m) {
                occupiedSeats.offer(reservation.end);
                utilization += reservation.end - reservation.start;
            } else {
                // �����ҵ������������λ������
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
        int m = 3; // ��λ��
        int n = 5; // վ����
        Reservation[] reservations = {
                new Reservation(0, 2),
                new Reservation(1, 3),
                new Reservation(2, 4),
                new Reservation(3, 5)
        };

        int maxUtilization = maxSeatUtilization(m, n, reservations);
        System.out.println("�����λ������: " + maxUtilization);
    }
}