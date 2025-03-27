package MyCollections;

import java.util.*;


//生无限大的棋盘中有 几 个炮，第讠个炮的坐标是(:,y)。
//知每个炮的攻击方式是:先选一个攻击方向(上、下、左、右)，该方向上看见的第一个棋子为“炮架”，该炮可以通过炮
//架攻击到炮架后面的棋子(只能攻击到炮架后面的第一个)
//"美希望你求出每个炮第一次攻击能攻击到多少个炮。
public class CannonAttack {
    public static List<Integer> countAttacks(List<Point> cannons) {
        // 按行和列分组存储炮
        Map<Integer, List<Point>> rowMap = new HashMap<>();
        Map<Integer, List<Point>> colMap = new HashMap<>();

        for (Point cannon : cannons) {
            rowMap.computeIfAbsent(cannon.y, k -> new ArrayList<>()).add(cannon);
            colMap.computeIfAbsent(cannon.x, k -> new ArrayList<>()).add(cannon);
        }

        // 对每组内的炮按坐标排序
        for (List<Point> row : rowMap.values()) {
            row.sort(Comparator.comparingInt(p -> p.x));
        }
        for (List<Point> col : colMap.values()) {
            col.sort(Comparator.comparingInt(p -> p.y));
        }

        List<Integer> result = new ArrayList<>();
        for (Point cannon : cannons) {
            int attackCount = 0;

            // 向上攻击
            List<Point> colUp = colMap.get(cannon.x);
            int indexUp = binarySearch(colUp, cannon);
            if (indexUp < colUp.size() - 2) {
                attackCount++;
            }

            // 向下攻击
            if (indexUp >= 2) {
                attackCount++;
            }

            // 向左攻击
            List<Point> rowLeft = rowMap.get(cannon.y);
            int indexLeft = binarySearch(rowLeft, cannon);
            if (indexLeft >= 2) {
                attackCount++;
            }

            // 向右攻击
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