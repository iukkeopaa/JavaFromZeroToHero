package MyCollections.FindSubtreeNodes;

import java.util.LinkedList;

//1~13 张扑克牌，将第一张放到最底下，第二张拿出来，第三张放到最底下，第四张拿出
//来，这样一直到剩最后一张牌，牌取出的顺序正好是 1~13，问牌原来的排列顺序；
public class PokerOrder {
    public static void main(String[] args) {
        LinkedList<Integer> result = new LinkedList<>();
        // 从 13 到 1 逆序遍历
        for (int i = 13; i >= 1; i--) {
            result.addFirst(i);
            if (result.size() > 1) {
                // 将最后一个元素移到头部
                int last = result.removeLast();
                result.addFirst(last);
            }
        }
        System.out.print("原来牌的排列顺序是: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}    