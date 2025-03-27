package MyCollections;

import java.util.*;


//�����޴���������� �� ���ڣ���ڥ���ڵ�������(:,y)��
//֪ÿ���ڵĹ�����ʽ��:��ѡһ����������(�ϡ��¡�����)���÷����Ͽ����ĵ�һ������Ϊ���ڼܡ������ڿ���ͨ����
//�ܹ������ڼܺ��������(ֻ�ܹ������ڼܺ���ĵ�һ��)
//"��ϣ�������ÿ���ڵ�һ�ι����ܹ��������ٸ��ڡ�
public class CannonAttack {
    public static List<Integer> countAttacks(List<Point> cannons) {
        // ���к��з���洢��
        Map<Integer, List<Point>> rowMap = new HashMap<>();
        Map<Integer, List<Point>> colMap = new HashMap<>();

        for (Point cannon : cannons) {
            rowMap.computeIfAbsent(cannon.y, k -> new ArrayList<>()).add(cannon);
            colMap.computeIfAbsent(cannon.x, k -> new ArrayList<>()).add(cannon);
        }

        // ��ÿ���ڵ��ڰ���������
        for (List<Point> row : rowMap.values()) {
            row.sort(Comparator.comparingInt(p -> p.x));
        }
        for (List<Point> col : colMap.values()) {
            col.sort(Comparator.comparingInt(p -> p.y));
        }

        List<Integer> result = new ArrayList<>();
        for (Point cannon : cannons) {
            int attackCount = 0;

            // ���Ϲ���
            List<Point> colUp = colMap.get(cannon.x);
            int indexUp = binarySearch(colUp, cannon);
            if (indexUp < colUp.size() - 2) {
                attackCount++;
            }

            // ���¹���
            if (indexUp >= 2) {
                attackCount++;
            }

            // ���󹥻�
            List<Point> rowLeft = rowMap.get(cannon.y);
            int indexLeft = binarySearch(rowLeft, cannon);
            if (indexLeft >= 2) {
                attackCount++;
            }

            // ���ҹ���
            if (indexLeft < rowLeft.size() - 2) {
                attackCount++;
            }

            result.add(attackCount);
        }
        return result;
    }

    private static int binarySearch(List<Point> points, Point target) {
        int left = 0, right = points.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (points.get(mid).x == target.x && points.get(mid).y == target.y) {
                return mid;
            } else if (points.get(mid).x < target.x || (points.get(mid).x == target.x && points.get(mid).y < target.y)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Point> cannons = new ArrayList<>();
        cannons.add(new Point(0, 0));
        cannons.add(new Point(0, 1));
        cannons.add(new Point(0, 2));
        cannons.add(new Point(1, 0));
        List<Integer> attacks = countAttacks(cannons);
        for (int attack : attacks) {
            System.out.println(attack);
        }
    }
}    